package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Config.class, args);
        Hasher myBean = context.getBean(Hasher.class);
    }
}