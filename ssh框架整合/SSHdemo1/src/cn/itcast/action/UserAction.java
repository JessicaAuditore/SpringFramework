package cn.itcast.action;

import cn.itcast.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    //注入service
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("action...............");
        userService.query();
        return NONE;
    }
}
