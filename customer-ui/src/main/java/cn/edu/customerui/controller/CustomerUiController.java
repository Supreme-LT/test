package cn.edu.customerui.controller;

import cn.edu.customerui.feign.CustomerUiFeign;
import cn.edu.goodscommons.domain.Customer;
import cn.edu.goodscommons.vo.ResultVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerUiController {

    @Resource
    private CustomerUiFeign customerUiFeign;

    /**
     * 查询所有顾客
     */
    @RequestMapping("/list")
    public List<Customer> list(){
        List<Customer> customerList = customerUiFeign.getCustomerList();
        return customerList;
    }

    /**
     * 根据id查询顾客
     */
    @RequestMapping("/detail/{id}")
    public ResultVo getById(@PathVariable("id") Integer id){
        return customerUiFeign.getById(id);
    }

    /**
     * 根据id删除顾客
     */
    @RequestMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        customerUiFeign.deleteById(id);//相当于发请求
    }

    /**
     * 添加顾客信息
     */
    @RequestMapping("/add")
    public void addCustomer(){
        Customer customer = new Customer();
        customer.setCustomerName("温迪");
        customer.setCustomerAddress("天空岛");
        customer.setCustomerTicket(0);
        customerUiFeign.addCustomer(customer);
    }

    /**
     * 编辑顾客信息
     */
    @RequestMapping("/update")
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId(4);
        customer.setCustomerName("雷电影");
        customer.setCustomerAddress("天空岛");
        customer.setCustomerTicket(0);
        customerUiFeign.updateCustomer(customer);
    }
}
