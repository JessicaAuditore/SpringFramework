package cn.itcast.action;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserAction extends ActionSupport {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //属性封装获取
    private int uid;
    private String username;
    private String realname;
    private String password;
    private String address;
    private String level;
    private String oldPassword;
    private String newPassword;
    private String repeatPassword;

    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    //登录
    public String login() {
        if (username == "") {
            ServletActionContext.getRequest().getSession().setAttribute("state", "error1");
            return "loginfail";
        }
        if (password == "") {
            ServletActionContext.getRequest().getSession().setAttribute("state", "error2");
            return "loginfail";
        }

        //封装到实体类对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用service方法实现
        User userExist = userService.login(user);

        //判断
        if (userExist == null) {
            //失败
            ServletActionContext.getRequest().getSession().setAttribute("state", "error3");
            return "loginfail";
        } else if (userExist.getPassword().equals(password)) {
            //成功
            //使用session保持登录状态
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("user", userExist);
            return "loginsuccess";
        } else {
            ServletActionContext.getRequest().getSession().setAttribute("state", "error4");
            return "loginfail";
        }
    }

    //退出
    public String exit() {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("state");
        return "exit";
    }

    //修改密码
    public String modify() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (!oldPassword.equals(user.getPassword()) || !newPassword.equals(repeatPassword) || newPassword.equals(oldPassword)) {
            return "modifyerror";
        }

        user.setPassword(newPassword);
        //重新登录
//        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);
        userService.update(user);
//        ServletActionContext.getRequest().getSession().setAttribute("state", "error5");
        return "modifysuccess";
    }

    public String list() {
        //返回到List放到值栈里面
        list = userService.findAll();
        return "list";
    }

    public String delete() {
        User u = userService.findOne(uid);
        if (u != null) {
            userService.delete(u);
        }
        return "delete";
    }

    public String showUser() {
        User u = userService.findOne(uid);
        ServletActionContext.getRequest().setAttribute("user", u);
        return "showUser";
    }

    public String updateUser() {
        User user = new User();
        user.setUid(uid);
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(realname);
        user.setAddress(address);
        user.setLevel(level);
        userService.update(user);
        return "updateUser";
    }
}
