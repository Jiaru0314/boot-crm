package com.niit.crm.service;

import com.niit.crm.mapper.CustomerMapper;
import com.niit.crm.pojo.Customer;
import com.niit.crm.pojo.QueryVo;
import com.niit.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> getCustomerByQueryVo(QueryVo vo) {
        vo.setStart((vo.getPage() - 1) * vo.getRows());
        //查询总记录数
        Integer total = customerMapper.getCountByQueryVo(vo);
        //查询每页的数据列表
        List<Customer> list = customerMapper.getCustomerByQueryVo(vo);
        //包装分页数据
        Page<Customer> page = new Page<>(total, vo.getPage(), vo.getRows(), list);

        return page;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }


}
