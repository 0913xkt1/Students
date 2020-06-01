package com.xkt.students_project_spring_boot.service.Impl;

import com.xkt.students_project_spring_boot.dao.PatriarchDao;
import com.xkt.students_project_spring_boot.domain.Patriarch;
import com.xkt.students_project_spring_boot.service.PatriarchServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatriarchServerImpl implements PatriarchServer {
    @Autowired
    PatriarchDao patriarchDao;

    public Patriarch findByIdAndByPassword(Integer patId,String password){
        return patriarchDao.findByIdAndByPassword(patId,password);
    }
}
