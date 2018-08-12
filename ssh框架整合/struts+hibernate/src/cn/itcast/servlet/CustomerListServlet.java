package cn.itcast.servlet;

import cn.itcast.entity.Customer;
import cn.itcast.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CustomerListServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        CustomerService service = new CustomerService();
        List<Customer> list = service.findAll();
        request.setAttribute("list", list);
        //到页面中
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
    }
}
