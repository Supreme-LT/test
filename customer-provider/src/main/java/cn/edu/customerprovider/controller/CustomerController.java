package cn.edu.customerprovider.controller;

import cn.edu.customerprovider.service.CustomerService;
import cn.edu.goodscommons.domain.Customer;
import cn.edu.goodscommons.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/list")
    public List<Customer> list(){
        return customerService.list();
    }

    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = customerService.getById(id);
        return ResultVo.ok(customer);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id){
        customerService.deleteById(id);
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "add success";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return "update success";
    }
}