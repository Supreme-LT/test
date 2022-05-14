package cn.edu.customerui.feign;

import cn.edu.customerui.feign.impl.CustomerUiFeignImpl;
import cn.edu.goodscommons.domain.Customer;
import cn.edu.goodscommons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "customer-provider",fallback = CustomerUiFeignImpl.class)//服务名
public interface CustomerUiFeign {

    @GetMapping("/customer/list")
    List<Customer> getCustomerList();

    @GetMapping("/customer/detail")
    ResultVo getById(@RequestParam("id") Integer id);

    @DeleteMapping("/customer/delete")
    void deleteById(@RequestParam("id") Integer id);

    @PostMapping("/customer/add")
    void addCustomer(@RequestBody Customer customer);

    @PutMapping("/customer/update")
    void updateCustomer(@RequestBody Customer customer);
}
