package com.demo.vo;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    @NonNull
    String name;
    Integer age;
    Integer sex;
}
