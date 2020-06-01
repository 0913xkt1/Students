package com.xkt.students_project_spring_boot.dao;

import com.xkt.students_project_spring_boot.domain.Patriarch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatriarchDao {
    /**
     * 登录
     * @param patId
     * @param password
     * @return
     */
    public Patriarch findByIdAndByPassword(Integer patId,String password);
    //    学生和家长的申请抽取到一个xml中,
    //    个人管理和修改密码抽一个xml中教师,学生,家长都用
//    个人所有成绩
//    按照时间查询所有科目成绩
//    班级单科成绩
//    班级总成绩
//    本次单科汇总成绩（按照时间查询）
//    申请请假
    //    查看历来请假及其状态
//    申请换班
    //    查看历来换班及其状态
//    申请换宿
    //    查看历来换宿及其状态
//    查看量化
//    个人信息修改(班级,年纪信息不能改)
//    密码修改

    /**
     * 个人信息修改
     * @param patriarch
     */
    void updatePatriarch(Patriarch patriarch);

}
