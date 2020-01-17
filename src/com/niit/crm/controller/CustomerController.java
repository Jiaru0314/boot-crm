package com.niit.crm.controller;

import com.niit.crm.pojo.BaseDict;
import com.niit.crm.pojo.Customer;
import com.niit.crm.pojo.QueryVo;
import com.niit.crm.service.BaseDictService;
import com.niit.crm.service.CustomerService;
import com.niit.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客户信息请求处理
 */

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @Value("${customer_from_type}")
    private String customer_from_type;
    @Value("${customer_industry_type}")
    private String customer_industry_type;
    @Value("${customer_level_type}")
    private String customer_level_type;


    @RequestMapping("list")
    public String list(Model model, QueryVo vo) {
//        Properties properties = new Properties();
        //查询数据来源
        List<BaseDict> fromType = baseDictService.getBaseDictByCode(customer_from_type);
        //查询行业类型
        List<BaseDict> industryType = baseDictService.getBaseDictByCode(customer_industry_type);
        //查询级别类型
        List<BaseDict> levelType = baseDictService.getBaseDictByCode(customer_level_type);

        //设置数据模型的返回
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        Page<Customer> page = customerService.getCustomerByQueryVo(vo);
        //设置分页数据返回
        model.addAttribute("page", page);
        return "customer";
    }

    @RequestMapping("edit")
    @ResponseBody//使用@ResponseBody，表示这个是处理ajax的请求
    public Customer edit(Integer id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping("update")
    public String update(Customer customer) {
        customerService.updateCustomer(customer);
        return "OK";
    }

    @RequestMapping("delete")
    @ResponseBody//使用@ResponseBody，表示这个是处理ajax的请求
    public void delete(Integer id) {
        customerService.deleteCustomer(id);
    }

}
