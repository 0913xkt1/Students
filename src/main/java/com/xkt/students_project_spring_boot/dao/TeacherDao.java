package com.xkt.students_project_spring_boot.dao;

import com.xkt.students_project_spring_boot.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    /**
     * 登录
     * @param teacherId
     * @param password
     * @return
     */
    Teacher findByIdAndByPassword(Integer teacherId,String password);
    //    学生和家长的申请抽取到一个xml中,个人管理和修改密码抽一个xml中教师,学生,家长都用
//    成绩管理(班主任权限)
    //    成绩excel录入
    //    成绩修改
    //    添加
    //    批量删除
    //    删除
//    成绩查看
    //    个人单科成绩
    //    个人总成绩
    //    班级单科成绩
    //    班级总成绩
//    本次单科汇总成绩（按照时间查询）
//    审核请假(班主任,年纪主任,校长权限)
    //    产看所有申请状态请假
    //    修改是否批准以及理由
    //    查看历来请假及其状态
//    审核换班(年纪主任权限)
    //    产看所有申请状态请假
    //    修改是否批准以及理由
    //    查看历来换班及其状态
//    审核换宿(宿管权限)
    //    产看所有申请状态奖学金
    //    修改是否批准以及理由
    //    查看历来换宿及其状态
//    审核奖学金(班主任权限权限)
    //    产看所有申请状态奖学金
    //    修改是否批准以及理由
    //    查看历来奖学金申请及其状态
//    审核贫困生(班主任权限)
    //    产看所有申请状态贫困生
    //    修改是否批准以及理由
    //    查看历来贫困生申请及其状态
//    量化excel录入(教导处权限，量化、成绩的查询在ApplicationAndReview中)
    //    量化修改
    //    添加
    //    批量删除
    //    删除
    //    查看量化
//    公告管理(班级班主任权限,年纪年纪主任权限,全校教导处权限，语句和Admin中的一样)
    //    添加
    //    查看自己发布的公告
    //    查看所有公告
//    个人信息修改(班级,年纪信息不能改)
//    密码修改|
    /**
     * 个人信息修改
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 批量删除成绩（年纪主任权限）
     * @param score_id
     */
    void deleteBathesScore(Integer[] score_id);

    /**
     * 删除单条成绩
     * @param scoreId
     */
    void deleteScore(Integer scoreId);

    /**
     * excel导入
     * @param score
     */
    void addScoret(Score score);

    /**
     * 查询成绩Id是否存在
     * @param scoreId
     * @return
     */
    String selectScoreId(Integer scoreId);

    /**
     * 批量删除量化
     * @param quan_id
     */
    void deleteBathesQuan(Integer[] quan_id);

    /**
     * 删除单条量化
     * @param quanId
     */
    void deleteQuan(Integer quanId);

    /**
     * excel导入量化
     * @param quantification
     */
    void addStudentQuan(Quantification quantification);

    /**
     * 查询量化Id是否存在
     * @param quanId
     * @return
     */
    String selectQuanId(Integer quanId);
    /**
     * 审核一审请假申请
     * @param applicationLeave
     */
    void updateOneApplicatLeave(ApplicationLeave applicationLeave);
    /**
     * 审核二审请假申请
     * @param applicationLeave
     */
    void updateTwoApplicatLeave(ApplicationLeave applicationLeave);
    /**
     * 审核三审请假申请
     * @param applicationLeave
     */
    void updateThreeApplicatLeave(ApplicationLeave applicationLeave);

    /**
     * 查看一审请假状态
     * @param one_review_id
     * @return
     */
    List<ApplicationLeave> selectOneApplicationLeave(Integer one_review_id);
    /**
     * 查看批过一审请假
     * @param one_review_id
     * @return
     */
    List<ApplicationLeave> selectOneApplicationLeaveAll(Integer one_review_id);
    /**
     * 查看二审请假状态
     * @param two_review_id
     * @return
     */
    List<ApplicationLeave> selectTwoApplicationLeave(Integer two_review_id);
    /**
     * 查看批过二审请假
     * @param two_review_id
     * @return
     */
    List<ApplicationLeave> selectTwoApplicationLeaveAll(Integer two_review_id);

    /**
     * 查看待批三审审请假
     * @param three_review_id
     * @return
     */
    List<ApplicationLeave> selectThreeApplicationLeave(Integer three_review_id);
    /**
     * 查看批过三审请假
     * @param three_review_id
     * @return
     */
    List<ApplicationLeave> selectThreeApplicationLeaveAll(Integer three_review_id);

    /**
     * 审核换班
     * @param applicationClass
     */
    void upDateApplicatClass(ApplicationClass applicationClass);

    /**
     * 查看待批换班
     * @param teaId
     * @return
     */
    List<ApplicationClass> selectApplicationClass(Integer teaId);
    /**
     * 查看批过的换班
     * @param teaId
     * @return
     */
    List<ApplicationClass> selectApplicationClassAll(Integer teaId);

    /**
     * 审核换宿
     * @param applicationDorm
     */
    void updateApplicatDorm(ApplicationDorm applicationDorm);

    /**
     * 查看待审核换宿
     * @param teaId
     * @return
     */
    List<ApplicationClass> selectApplicationDorm(Integer teaId);
    /**
     * 查看所有批过的换宿
     * @param teaId
     * @return
     */
    List<ApplicationClass> selectApplicationDormAll(Integer teaId);
    /**
     * 审核贫困生
     * @param poor
     */
    void updatePoor(Poor poor);
    /**
     * 查看待审批贫困生
     * @param teaId
     * @return
     */
    List<Poor> selectPoor(Integer teaId);
    /**
     * 查看批过的贫困生申请
     * @param teaId
     * @return
     */
    List<Poor> selectPoorAll(Integer teaId);
    /**
     * 审核奖学金
     * @param poor
     */
    void updateScholarship(Scholarship poor);
    /**
     * 查看待批准奖学金
     * @param teaId
     * @return
     */
    List<Scholarship> selectScholarship(Integer teaId);

    /**
     * 通过教师id查找教师姓名
     * @param teaId
     * @return
     */
    String selectTeacherNameByTeacherId(Integer teaId);
    /**
     * 查看所有批过的奖学金
     * @param teaId
     * @return
     */
    List<Scholarship> selectScholarshipAll(Integer teaId);
}
