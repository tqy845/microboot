package com.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.domain.Customers;
import com.demo.mapper.CustomersMapper;
import com.demo.service.ICustomersService;
import org.springframework.stereotype.Service;

@Service
public class ICustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements ICustomersService {

}
