package com.xkt.students_project_spring_boot.service.Impl;

import com.xkt.students_project_spring_boot.dao.TeacherDao;
import com.xkt.students_project_spring_boot.domain.Teacher;
import com.xkt.students_project_spring_boot.service.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServerImpl implements TeacherServer {

    @Autowired
    TeacherDao teacherDao;
    public Teacher findByIdAndByPassword(Integer teacherId,String password){
        return teacherDao.findByIdAndByPassword(teacherId,password);
    }
}
