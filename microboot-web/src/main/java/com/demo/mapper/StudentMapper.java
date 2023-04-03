package com.demo.mapper;

import org.springframework.stereotype.Repository;

@Repository
public class StudentMapper {
    public void save() {
        System.out.println("save() in mapper");
    }
}
