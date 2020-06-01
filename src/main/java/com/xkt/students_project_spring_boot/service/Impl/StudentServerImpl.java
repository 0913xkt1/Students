package com.xkt.students_project_spring_boot.service.Impl;

import com.xkt.students_project_spring_boot.dao.StudentDao;
import com.xkt.students_project_spring_boot.domain.Student;
import com.xkt.students_project_spring_boot.service.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServerImpl implements StudentServer {
    @Autowired
    StudentDao studentDao;

    public Student findByIdAndByPassword(Integer stuId,String password){
        return studentDao.findByIdAndByPassword(stuId,password);
    }
}
