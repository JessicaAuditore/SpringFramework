package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkManService linkManService;
    private CustomerService customerService;

    private LinkMan linkMan = new LinkMan();

    public LinkMan getModel() {
        return linkMan;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private List<LinkMan> list;

    public List<LinkMan> getList() {
        return list;
    }

    /*
     *  需要上传文件（流）
     *  需要上传文件名称
     *  （1）在action里面成员变量定义变量
     *   - 一个表示上传文件
     *   - 一个表示文件名称
     *  （2）生产变量的get和set方法
     *
     *  还有一个变量，上传文件的mine类型
     * */
    //1 上传文件
    //变量名称要是表单里面上传的name值
    private File upload;
    //2 上传文件名称 表单里面文件上传项的name值FileName
    private String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    //////////////////////////////////////

    public String toAddPage() {
        //查询出所有客户，把所有客户list集合传递到页面中显示（放到域对象）
        List<Customer> listCustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
        return "toAddPage";
    }

    public String add() throws IOException {
        //判断用户是否需要上传文件
        if (upload != null) {
            //写上传代码
            //在服务器文件夹里面创建文件
            File serverFile = new File("D:\\sshimg\\" + uploadFileName);
            //把上传文件复制到服务器文件里面
            FileUtils.copyFile(upload, serverFile);
        }

        /*
         * 可以封装联系人基本信息
         * 但是cid是客户id值不能直接封装的
         * 把cid封装LinkMan实体类里面customer对象里面
         * */

        //1
//        String scid = ServletActionContext.getRequest().getParameter("cid");
//        int cid = Integer.parseInt(scid);
//        Customer c = new Customer();
//        c.setCid(cid);
//        linkMan.setCustomer(c);
        //2
        //<select name="customer.cid">
        linkManService.save(linkMan);
        return "add";
    }

    public String list() {
        list = linkManService.findAll();
//        for (int i = 0; i < list.size(); i++) {
//            Customer customer=customerService.findOne(list.get(i).getCustomer().getCid());
//            list.get(i).setCustomer(customer);
//        }
        return "list";
    }

    public String showLinkMan() {
        int lkmId = linkMan.getLkmId();
        LinkMan l = linkManService.findOne(lkmId);
        ServletActionContext.getRequest().setAttribute("linkman", l);
        List<Customer> listCustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
        return "showLinkMan";
    }

    public String updateLinkMan() {
        linkManService.update(linkMan);
        return "updateLinkMan";
    }

    public String delete() {
        int lkmId = linkMan.getLkmId();
        LinkMan l = linkManService.findOne(lkmId);
        if (l != null) {
            linkManService.delete(linkMan);
        }
        return "delete";
    }

    public String undertake() {
        if (linkMan.getLkmName() == null) {
            list = linkManService.findAll();
        } else {
            list = linkManService.findSome(linkMan.getLkmName());
        }
        return "undertake";
    }

    public String toSelectLinkManPage() {
        List<Customer> listCustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
        return "toSelectLinkManPage";
    }

    public String query() {
        list = linkManService.query(linkMan);
        return "query";
    }

    ///////////////json

    public String linkmanJson() throws IOException {
        List<LinkMan> list = linkManService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", list.size());
        map.put("rows", list);
        //禁止循环调用
        String json = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        return NONE;
    }
}
