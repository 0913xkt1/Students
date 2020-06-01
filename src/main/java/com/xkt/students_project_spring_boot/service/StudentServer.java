package com.xkt.students_project_spring_boot.service;

import com.xkt.students_project_spring_boot.domain.Student;

public interface StudentServer {
    Student findByIdAndByPassword(Integer stuId,String password);
}
