package com.xkt.students_project_spring_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xkt.students_project_spring_boot.dao")
public class StudentsProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsProjectSpringBootApplication.class, args);
    }

}
