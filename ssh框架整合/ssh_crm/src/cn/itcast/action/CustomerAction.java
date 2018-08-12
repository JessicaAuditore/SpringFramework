package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    //定义list变量
    private List<Customer> list;

    //生产变量的get方法
    public List<Customer> getList() {
        return list;
    }

    //使用属性封装
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    //////////////////////////////////////action

    //分页的方法
    public String listPage() {
        //调用service的方式实现封装
        PageBean pageBean = customerService.listPage(currentPage);

        //放到域对象里面
        ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
        return "listPage";
    }

    //1 到添加页面
    public String toAddPage() {
        List<Dict> listDict = customerService.findAllDictLevel();
        ServletActionContext.getRequest().setAttribute("listDict", listDict);
        return "toAddPage";
    }

    //2 添加的方法
    public String add() {
        customerService.save(customer);
        return "add";
    }

    //3 客户列表
    public String list() {
//        List<Customer> list = customerService.findAll();
        //放到域对象
//        ServletActionContext.getRequest().setAttribute("list", list);
        //返回到List放到值栈里面
        list = customerService.findAll();
        return "list";
    }

    //4 客户列表筛选
    public String undertake() {
        if (customer.getCustName() == null) {
            list = customerService.findAll();
        } else {
            list = customerService.findSome(customer.getCustName());
        }
        return "undertake";
    }

    //5 删除
    public String delete() {
        //删除规范写法：首先根据id查询，调用方法删除
        //使用模型驱动获取表单提交cid值
        int cid = customer.getCid();

        //根据id查询
        Customer c = customerService.findOne(cid);

        if (c != null) {
            //调用方法删除
            customerService.delete(c);
        }
        return "delete";
    }

    //6修改操作 1 根据id查询
    public String showCustomer() {
        int cid = customer.getCid();

        //根据id查询
        Customer c = customerService.findOne(cid);

        //放到域对象里面
        ServletActionContext.getRequest().setAttribute("customer", c);
        List<Dict> listDict = customerService.findAllDictLevel();
        ServletActionContext.getRequest().setAttribute("listDict", listDict);
        return "showCustomer";
    }

    //6修改操作 2 保存修改后的客户
    public String updateCustomer() {
        customerService.update(customer);
        return "updateCustomer";
    }

    public String toSelectCustomerPage() {
        List<Dict> listDict = customerService.findAllDictLevel();
        ServletActionContext.getRequest().setAttribute("listDict", listDict);
        List listSource = customerService.findAllSource();
        ServletActionContext.getRequest().setAttribute("listSource", listSource);
        return "toSelectCustomerPage";
    }

    public String query() {
        list = customerService.query(customer);
        return "query";
    }

    public String countSource() {
        List list = customerService.fingCountSource();
        ServletActionContext.getRequest().setAttribute("list", list);
        return "countSource";
    }

    public String countLevel() {
        List list = customerService.fingCountLevel();
        ServletActionContext.getRequest().setAttribute("list", list);
        return "countLevel";
    }

    //////////////////////////////json

    //得到所有客户json数据的方法
    public String customerJson() throws IOException {
        //查询所有客户，返回list集合，把list集合转换json格式
        //{"total":数量,"rows":[{},{}]}
        //使用类里面的方法实现
        //JSON.toJSONString();

        //1 对象转换
//        Customer customer1 = new Customer();
//        customer1.setCustName("Lucy");
//        customer1.setCustSource("网络");
//        customer1.setCustMobile("123");
//        customer1.setCid(1);
//        String json = JSON.toJSONString(customer1);

        //1 查询所有客户，返回List集合
        List<Customer> list = customerService.findAll();
        //2 把list转换json数据格式
        //思想：结构名称和值，使用map集合进行数据封装，再进行转换
        //2.1 创建map集合
        Map<String, Object> map = new HashMap<String, Object>();
        //2.2 添加数据
        //total表示数量
        map.put("total", list.size());
        map.put("rows", list);
        //3 把map转换json数据格式
        //禁止循环调用
        String json = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);

        //使用response对象进行返回
        HttpServletResponse response = ServletActionContext.getResponse();
        //返回json格式时候，写出application/json
        response.setContentType("application/json;charset=utf-8");
        //如果使用response返回数据，action里面不能有返回值
        response.getWriter().write(json);
        return NONE;
    }

    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String customerPageJson() throws IOException {
        int begin = (page - 1) * rows;
        //得到分页list集合
        List<Customer> list = customerService.findPageJson(begin, rows);
        //得到总记录数
        int count = customerService.findCount();
        //返回Json格式
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        //禁止循环调用
        String json = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        //输出
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        return NONE;
    }

    public String customerDict() throws IOException{
        List<Dict> listDict = customerService.findAllDictLevel();
        String json = JSON.toJSONString(listDict, SerializerFeature.DisableCircularReferenceDetect);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        return NONE;
    }
}
