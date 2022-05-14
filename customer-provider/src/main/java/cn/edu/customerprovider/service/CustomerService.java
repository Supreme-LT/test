package cn.edu.customerprovider.service;

import cn.edu.goodscommons.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> list();

    Customer getById(Integer id);

    void deleteById(Integer id);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
