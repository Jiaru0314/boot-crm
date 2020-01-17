package com.niit.crm.mapper;

import com.niit.crm.pojo.Customer;
import com.niit.crm.pojo.QueryVo;

import java.util.List;

/**
 * 客户信息持久化接口
 */
public interface CustomerMapper {

    /**
     * 分页查询用户列表
     *
     * @param vo
     * @return
     */
    List<Customer> getCustomerByQueryVo(QueryVo vo);

    /**
     * 根据查询条件查询总记录数
     *
     * @param vo
     * @return
     */
    Integer getCountByQueryVo(QueryVo vo);

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
