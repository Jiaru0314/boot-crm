package com.niit.crm.service;

import com.niit.crm.pojo.Customer;
import com.niit.crm.pojo.QueryVo;
import com.niit.crm.utils.Page;

import java.util.List;

/**
 * 客户信息业务逻辑接口
 */
public interface CustomerService {

    /**
     * 分页查询用户列表
     *
     * @param vo
     * @return
     */
    Page<Customer> getCustomerByQueryVo(QueryVo vo);

    /**
     * 根据用户id查询信息
     *
     * @param id
     * @return
     */
    Customer getCustomerById(Integer id);

    /**
     * 更新用户信息
     *
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 删除用户信息
     *
     * @param id
     */
    void deleteCustomer(Integer id);
}
