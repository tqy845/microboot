package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.domain.Customers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {

}
