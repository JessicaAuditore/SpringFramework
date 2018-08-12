package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {

    private VisitService visitService;
    private CustomerService customerService;
    private UserService userService;
    private List<Visit> list;
    private Visit visit = new Visit();

    @Override
    public Visit getModel() {
        return visit;
    }

    public List<Visit> getList() {
        return list;
    }

    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //////////////////////////////////////

    public String toAddPage() {
        List<Customer> customerList = customerService.findAll();
        List<User> userList = userService.findAll();
        ServletActionContext.getRequest().setAttribute("customerList", customerList);
        ServletActionContext.getRequest().setAttribute("userList", userList);
        return "toAddPage";
    }

    public String list() {
        list = visitService.findAll();
        return "list";
    }

    public String add() {
        visitService.save(visit);
        return "add";
    }

    public String delete() {
        int vid = visit.getVid();
        Visit v = visitService.findOne(vid);
        if (v != null) {
            visitService.delete(visit);
        }
        return "delete";
    }

    public String showVisit() {
        int vid = visit.getVid();
        Visit v = visitService.findOne(vid);
        ServletActionContext.getRequest().setAttribute("visit", v);
        List<Customer> customerList = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("customerList", customerList);
        List<User> userList = userService.findAll();
        ServletActionContext.getRequest().setAttribute("userList", userList);
        return "showVisit";
    }

    public String updateVisit() {
        visitService.update(visit);
        return "updateVisit";
    }

    public String toSelectVisitPage() {
        List<Customer> listCustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
        List<User> listUser = userService.findAll();
        ServletActionContext.getRequest().setAttribute("listUser", listUser);
        return "toSelectVisitPage";
    }

    public String query() {
        list=visitService.query(visit);
        return "query";
    }
}
