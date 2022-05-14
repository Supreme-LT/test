package cn.edu.customerui.feign.impl;

import cn.edu.customerui.feign.CustomerUiFeign;
import cn.edu.goodscommons.domain.Customer;
import cn.edu.goodscommons.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUiFeignImpl implements CustomerUiFeign {
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public ResultVo getById(Integer id) {
        return ResultVo.error("feign的服务降级响应");
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
