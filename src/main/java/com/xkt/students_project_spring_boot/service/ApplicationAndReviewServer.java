package com.xkt.students_project_spring_boot.service;

import com.xkt.students_project_spring_boot.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ApplicationAndReviewServer {
    /**
     * 学生所有成绩
     * @param stuId
     * @return
     */
    List<Score> studentScores(Integer stuId);

    /**
     * 按照时间考试成绩
     * @param stuId
     * @param scoreDate
     * @return
     */
    List<Score> studentTimeScore(Integer stuId, String scoreDate,String scoreName);

    /**
     * 按照时间段考试成绩,从前端传过来的时间格式转为字符串后在传入，查询的结果通过转换后传入前端
     * @param stuId
     * @param scoreDate
     * @return
     */
    List<Score> studentTimesScore(Integer stuId, String scoreDate, String scoreDate1,String scoreName);

    /**
     * 查询一个班级所有成绩
     * @param class_id
     * @return
     */
    List<Score> classScore(Integer class_id);


    /**
     * 按照时间查询一个班级成绩
     * @param class_id
     * @return
     */
    List<Score> classTimeScore(Integer class_id, String scoreDate,String scoreName);

    /**
     * 按照时间段查询一个班级成绩
     * @param class_id
     * @return
     */
    List<Score> classTimesScore(Integer class_id, String scoreDate, String scoreDate1,String scoreName);

    /**
     * 班级成绩对比，按照时间查询所有班级成绩
     * @param scoreDate
     * @return
     */
    List<Score> classContrastScore(String scoreDate,String scoreName);

    /**
     * 请假申请
     * @param applicationLeave
     */
    void addApplicatLeave(ApplicationLeave applicationLeave);

    /**
     * 查看请假状态，（这个是给家长看的）
     * @param applicatId
     * @return
     */
    List<ApplicationLeave> selectApplicationLeave(Integer applicatId);
    /**
     * 查看请假状态，（这个是给学生看的）
     * @param stuId
     * @return
     */
    List<ApplicationLeave> selectApplicationLeave1(Integer stuId);
    /**
     * 换班申请
     * @param applicationClass
     */
    void addApplicatClass(ApplicationClass applicationClass);

    /**
     * 查看换班状态，（这个是给家长看的）
     * @param applicatId
     * @return
     */
    List<ApplicationClass> selectApplicationClass(Integer applicatId);
    /**
     * 查看换班状态，（这个是给学生看的）
     * @param stuId
     * @return
     */
    List<ApplicationClass> selectApplicationClass1(Integer stuId);

    /**
     * 换宿申请
     * @param applicationDorm
     */
    void addApplicatDorm(ApplicationDorm applicationDorm);

    /**
     * 查看换宿状态，（这个是给家长看的）
     * @param applicatId
     * @return
     */
    List<ApplicationDorm> selectApplicationDorm(Integer applicatId);
    /**
     * 查看换宿状态，（这个是给学生看的）
     * @param stuId
     * @return
     */
    List<ApplicationDorm> selectApplicationDorm1(Integer stuId);

    /**
     * 查询学生所有量化
     * @return
     */
    List<Quantification> selectQuans();
    /**
     * 按照时间段查询学生所有量化
     * @param stu_id
     * @return
     */
    List<Quantification> selectTimeQuans(Integer stu_id, String quanDate, String quanDate1);

    /**
     * 申请贫困生
     * @param poor
     */
    void addPoor(Poor poor);
    /**
     * 查看贫困生申请状态
     * @param stuId
     * @return
     */
    List<Poor> selectPoor(Integer stuId);
    /**
     * 申请奖学金
     * @param poor
     */
    void addScholarship(Scholarship poor);
    /**
     * 查看奖学金申请状态
     * @param stuId
     * @return
     */
    List<Scholarship> selectScholarship(Integer stuId);
    /**    修改学生信息
     *
     */
    void updateStudent(Student student);

    /**
     * 修改家长信息
     * @param patriarch
     */
    void updatePatriarch(Patriarch patriarch);

    /**
     * 修改教师信息
     * @param teacher
     */
    void updateTeacher(Teacher teacher);
    /**
     * 查看学生量化
     * @param stu_id
     * @return
     */
    List<Quantification> selectStudentQuan( Integer stu_id);

    //添加成绩
    public String addexcelScore(String fileName, MultipartFile file) throws Exception;
    //    教师查看班级成绩

    public List<Score> selectClassScore();
    //    班级成绩对比

    public List<Score> selectClasssScore(Integer classId, Date scoreDate);
    //批量删除成绩

    public void  deleteScores( Integer [] scoreId);
    //删除成绩

    public void  deleteScore( Integer scoreId);


    //添加量化
    public String addexcelQuan(String fileName, MultipartFile file);

    //批量删除量化

    public void  deleteQuans( Integer [] scoreId);
    //删除量化

    public void  deleteQuan( Integer quanId);
//    审核奖学金
    /**
     * 审核奖学金
     * return
     */

    public void updateScholarship(Scholarship scholarship);

    /**
     * 审核贫困生
     * return
     */
    public void updatePoor( Poor poor);
    /**
     * 教师查看贫困生申请状态
     * param applicatId
     * return
     */

    public List<Poor> teacherPoor( Integer applicatId);
    /**
     * 教师查看奖学金申请状态
     * param applicatId
     * return
     */

    public List<Scholarship> teacherScholarship( Integer applicatId);
    /**
     * 教师查看换班申请状态
     * param applicatId
     * return
     */


    public List<ApplicationClass> teacherApplicationClass( Integer applicatId);
    /**
     * 教师查看换宿申请状态
     * param applicatId
     * return
     */

    public List<ApplicationDorm> teacherApplicationDorm3( Integer applicatId);
    /**
     * 一审教师查看请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherOneApplicationLeave( Integer applicatId);
    /**
     * 二审教师查看请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherTwoApplicationLeave( Integer applicatId);
    /**
     * 三审教师查看请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherThreeApplicationDorm( Integer applicatId);

    /**
     * 教师查看已审核贫困生申请状态
     * param applicatId
     * return
     */

    public List<Poor> teacherPoor6( Integer applicatId);
    /**
     * 教师查看已审核奖学金申请状态
     * param applicatId
     * return
     */

    public List<Scholarship> teacherScholarship6( Integer applicatId);
    /**
     * 教师查看已审核换班申请状态
     * param applicatId
     * return
     */


    public List<ApplicationClass> teacherApplicationClass6( Integer applicatId);
    /**
     * 教师查看已审核换宿申请状态
     * param applicatId
     * return
     */

    public List<ApplicationDorm> teacherApplicationDorm6( Integer applicatId);
    /**
     * 一审教师查看已审核请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherOneApplicationLeave6( Integer applicatId);
    /**
     * 二审教师查看已审核请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherTwoApplicationLeave6( Integer applicatId);
    /**
     * 三审教师查看已审核请假申请状态
     * param applicatId
     * return
     */

    public List<ApplicationLeave> teacherThreeApplicationDorm6( Integer applicatId);
    //    审核请假
    /**
     * 审核请假
     * return
     */

    public void updateOneApplicationLeave( ApplicationLeave applicationLeave);
    /**
     * 二审审核请假
     * return
     */

    public void updateTwoApplicationLeave(ApplicationLeave applicationLeave);
    /**
     * 三审审核请假
     * return
     */


    public void updateThreeApplicationLeave( ApplicationLeave applicationLeave);
//    审核换宿
    /**
     * 审核换宿
     * return
     */
    public void updateApplicatDorm( ApplicationDorm applicationDorm);
//    审核换班
    /**
     * 审核换班
     * return
     */


    public void updateApplicationClass( ApplicationClass applicationClass);
}
