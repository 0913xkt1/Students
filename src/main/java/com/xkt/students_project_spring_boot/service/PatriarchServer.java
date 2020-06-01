package com.xkt.students_project_spring_boot.service;

import com.xkt.students_project_spring_boot.domain.Patriarch;

public interface PatriarchServer {
    public Patriarch findByIdAndByPassword(Integer patId,String password);
}
