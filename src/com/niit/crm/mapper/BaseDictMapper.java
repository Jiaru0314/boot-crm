package com.niit.crm.mapper;

import com.niit.crm.pojo.BaseDict;

import java.util.List;

/**
 * 字典数据持久接口
 */
public interface BaseDictMapper {
    /**
     * 根据字典编码查询字典列表
     * @param code
     * @return
     */
    List<BaseDict> getBaseDictByCode(String code);
}