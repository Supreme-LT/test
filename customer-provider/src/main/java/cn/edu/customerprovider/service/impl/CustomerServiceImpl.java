package cn.edu.customerprovider.service.impl;

import cn.edu.customerprovider.dao.CustomerDao;
import cn.edu.customerprovider.service.CustomerService;
import cn.edu.goodscommons.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Override
    public List<Customer> list() {
        return customerDao.list();
    }

    @Override
    public Customer getById(Integer id) {
        return customerDao.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }
}
