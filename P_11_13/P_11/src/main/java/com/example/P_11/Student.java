package com.example.P_11;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.yml")

@Component
public class Student {
    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String last_name;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(last_name);
        System.out.println(group);
    }





}
