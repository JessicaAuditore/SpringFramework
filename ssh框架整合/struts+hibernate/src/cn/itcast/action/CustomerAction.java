package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    private List<Customer> list=new ArrayList<Customer>();

    public List<Customer> getList() {
        return list;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    //添加的方法
    public String addCustomer() {
        //调用service的方法添加数据库
        CustomerService service = new CustomerService();
        service.addCustomer(customer);
        return "addCustomer";
    }

    //到添加页面
    public String toAddPage() {

        return "toAddPage";
    }

    //客户列表
    public String list() {
        //调用service
        CustomerService service = new CustomerService();
        list = service.findAll();

        //放到域对象
//        HttpServletRequest request = ServletActionContext.getRequest();
//        request.setAttribute("list", list);

        return "list";
    }
}
