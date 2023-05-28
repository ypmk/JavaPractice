package com.example.P_11;

import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.yml")

@SpringBootApplication
public class P11Application {

	public static void main(String[] args) {
		Student student=new Student();
		student.init();
		SpringApplication.run(P11Application.class, args);

	}



}



