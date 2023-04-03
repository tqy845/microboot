package com.demo.service.Impl;

import com.demo.mapper.StudentMapper;
import com.demo.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void save() {
        System.out.println("save() in service");
        studentMapper.save();
    }
}
