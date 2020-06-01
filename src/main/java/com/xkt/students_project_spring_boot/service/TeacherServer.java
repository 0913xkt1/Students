package com.xkt.students_project_spring_boot.service;

import com.xkt.students_project_spring_boot.domain.Teacher;

public interface TeacherServer {
    Teacher findByIdAndByPassword(Integer teacherId,String password);
}
