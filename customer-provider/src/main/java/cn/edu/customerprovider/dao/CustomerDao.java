package cn.edu.customerprovider.dao;

import cn.edu.goodscommons.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface CustomerDao {
    public List<Customer> list();

    public void addCustomer(Customer customer);

    public void deleteById(Integer id);

    public void update(Customer customer);

    public Customer getById(Integer id);
}
