package com.xkt.students_project_spring_boot.controller;

import com.xkt.students_project_spring_boot.domain.*;
import com.xkt.students_project_spring_boot.service.Impl.ApplicationAndReviewServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("stu_pat")
public class StudentAndPatController {
    @Autowired
    private ApplicationAndReviewServerImpl applicationAndReviewServer;
    /**
     * 查看个人所有成绩
     */
    @ResponseBody
    @RequestMapping(value = "/select_student_scores", method = RequestMethod.POST)
    public List<Score> studentScores(@RequestParam Integer params){
        System.out.println(params+"hhh");
        System.out.println(applicationAndReviewServer.studentScores(params));
        return applicationAndReviewServer.studentScores(params);
    }
    /**
     * 按照时间考试成绩
     * @param stuId
     * @param scoreDate
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_time_scores", method = RequestMethod.POST)
    List<Score> studentTimeScore(@RequestParam Integer stuId, @RequestParam Date scoreDate,@RequestParam String scoreName){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String hhh = sdf.format(scoreDate);
        return applicationAndReviewServer.studentTimeScore(stuId,hhh,scoreName);
    }
    /**
     * 按照时间段考试成绩,从前端传过来的时间格式转为字符串后在传入，查询的结果通过转换后传入前端
     * @param scoreDate
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_times_scores", method = RequestMethod.POST)
    List<Score> studentTimesScore(@RequestParam Integer username, @DateTimeFormat(pattern="yyyy-MM-dd") Date scoreDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date scoreDate1, @RequestParam String scoreName){
//        System.out.println(scoreDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String date1 ;
        String date2 ;
        String scoreName1 = scoreName;
        if ("假".equals(scoreName)){
//            date1 = sdf.format(new Date());
//            c.setTime(new Date());
//            c.add(Calendar.MONTH, -1);
//            date2 = sdf.format(c.getTime());
            date1 = "2011-01-01";
            date2 = "2021-01-01";

            System.out.println(username);
            System.out.println(date1);
            System.out.println(date2);
            scoreName1 = "语文";
        }else{

             date1 = sdf.format(scoreDate);
             date2 = sdf.format(scoreDate);
        }
        List<Score> list =applicationAndReviewServer.studentTimesScore(username,date1,date2,"语文");
        for (Score score:list){
            System.out.println(score);
        }
        return applicationAndReviewServer.studentTimesScore(username,date1,date2,scoreName1);
//        return null;
    }
/**
 * 请假申请
 */
    @ResponseBody
    @RequestMapping(value = "/add_applicat_leave", method = RequestMethod.POST)
    public String addApplicatLeave(@RequestParam String reason,@RequestParam Integer applicationId,
                                   @RequestParam Integer days, @RequestParam String stuName,
                                   @RequestParam Integer stuId, @RequestParam Integer OneReviewId,
                                   @RequestParam Integer TwoReviewId,@DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                                   @RequestParam Integer ThreeReviewId)

    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ApplicationLeave applicationLeave = new ApplicationLeave();
        applicationLeave.setReason(reason);
        applicationLeave.setApplicationId(applicationId);
//        try {
//            applicationLeave.setApplicationDate(sdf.parse(sdf.format(date)));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        applicationLeave.setApplicationDate(date);
        applicationLeave.setDays(days);
        System.out.println("审核人id");
        System.out.println(OneReviewId);
        applicationLeave.setOneReviewId(OneReviewId);
        applicationLeave.setStuId(stuId);
        applicationLeave.setStuName(stuName);
        applicationLeave.setTwoReviewId(TwoReviewId);
        applicationLeave.setThreeReviewId(ThreeReviewId);
        applicationLeave.setState("0");
        applicationAndReviewServer.addApplicatLeave(applicationLeave);
        return "申请成功";
    }

    /**
     * 查看请假
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_leave", method = RequestMethod.POST)
    public List<ApplicationLeave> selectApplicationLeave(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationLeave(applicatId);
    }
    /**
     * 学生版查看请假
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_leave1", method = RequestMethod.POST)
    public List<ApplicationLeave> selectApplicationLeave1(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationLeave1(applicatId);
    }
    /**
     * 申请换班换班
     */
    @ResponseBody
    @RequestMapping(value = "/add_applicat_class", method = RequestMethod.POST)
    public String addApplicatClass(@RequestParam String reason,@RequestParam Integer applicatId,
                                   @RequestParam Integer stuId,@RequestParam Integer nowClassId,
                                   @RequestParam Integer wantClassId,@RequestParam String stuName,@RequestParam Integer reviewId){

        ApplicationClass applicationClass = new ApplicationClass();
        applicationClass.setReason(reason);
        applicationClass.setApplicatId(applicatId);
        applicationClass.setApplicantDate(new Date());
        applicationClass.setStuId(stuId);
        applicationClass.setState("0");
        applicationClass.setNowClassId(nowClassId);
        applicationClass.setWantClassId(wantClassId);
        applicationClass.setStuName(stuName);
        applicationClass.setReviewId(reviewId);

        applicationAndReviewServer.addApplicatClass(applicationClass);
        return "申请成功";

    }

    /**
     * 学生版查看换班
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_class1", method = RequestMethod.POST)
    public List<ApplicationClass> selectApplicationClass1(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationClass1(applicatId);
    }

    /**
     * 家长查看换班
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_class", method = RequestMethod.POST)
    public List<ApplicationClass> selectApplicationClass(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationClass(applicatId);
    }
//    换宿申请
    /**
     * 换宿申请
     */
    @ResponseBody
    @RequestMapping(value = "/add_applicat_dorm", method = RequestMethod.POST)
    public String addApplicatDorm(@RequestParam String reason,@RequestParam Integer applicatId,
                                   @RequestParam Integer stuId,@RequestParam Integer nowDormId,
                                   @RequestParam Integer wantDormId,@RequestParam String stuName,
                                   @RequestParam Integer reviewId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ApplicationDorm applicationDorm = new ApplicationDorm();
        applicationDorm.setReason(reason);
        applicationDorm.setApplicatId(applicatId);
        applicationDorm.setApplyForDate(new Date());
        applicationDorm.setStuId(stuId);
        applicationDorm.setState("0");
        applicationDorm.setNowDormId(nowDormId);
        applicationDorm.setWantDormId(wantDormId);
        applicationDorm.setStuName(stuName);
        applicationDorm.setReviewId(reviewId);
        applicationAndReviewServer.addApplicatDorm(applicationDorm);
        return "申请成功";
    }

    /**
     * 查看换宿
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_dorm", method = RequestMethod.POST)
    public List<ApplicationDorm> selectApplicationDorm(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationDorm(applicatId);
    }
    /**
     * 学生版查看换宿
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_applicat_dorm1", method = RequestMethod.POST)
    public List<ApplicationDorm> selectApplicationDorm1(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectApplicationDorm1(applicatId);
    }


//    查看量化
    /**
     * 查看所有量化
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selece_quan", method = RequestMethod.POST)
    public List<Quantification> selectQuans(){
        return applicationAndReviewServer.selectQuans();
    }
    /**
     * 查询学生量化
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selece_quan_student", method = RequestMethod.POST)
    public List<Quantification> selectStudentQuan(@RequestParam Integer stu_id){

        return applicationAndReviewServer.selectStudentQuan(stu_id);

    }
//修改个人信息

    /**
     * 修改学生信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_student", method = RequestMethod.POST)
    public String updateStudent(@RequestParam String name,@RequestParam String password
                                ,@RequestParam String sex,@RequestParam Integer singleParent,
                                @RequestParam Integer subsidy,@RequestParam Integer stuId){
        Student student = new Student();
        student.setStuId(stuId);
        student.setStuName(name);
        student.setSex(sex);
        student.setSubsidy(subsidy);
        student.setSingleParent(singleParent);
        student.setPassword(password);
applicationAndReviewServer.updateStudent(student);
    return "修改成功";
}
    /**
     * 修改家长信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_patriarch", method = RequestMethod.POST)
    public String updatePatriarch(@RequestParam Integer patId,@RequestParam String cellPhoneNumber,
                                  @RequestParam String name,
                                  @RequestParam String password,@RequestParam String sex){
        System.out.println("行吧"+sex);
        Patriarch patriarch = new Patriarch();
        patriarch.setPatId(patId);
        patriarch.setSex(sex);
        patriarch.setCellPhoneNumber(cellPhoneNumber);
        patriarch.setPatName(name);
        patriarch.setPassword(password);
        applicationAndReviewServer.updatePatriarch(patriarch);
        return "修改成功";
    }
    /**
     * 修改教师信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_teacher", method = RequestMethod.POST)
    public String updateTeacher(@RequestParam Integer teacherId,@RequestParam String name,@RequestParam String password){
        Teacher teacher = new Teacher();
        teacher.setPassword(password);
        teacher.setTeacherId(teacherId);
        teacher.setTeacherName(name);
        applicationAndReviewServer.updateTeacher(teacher);
        return "修改成功";
    }
//    申请奖学金
//    查看申请状态
    /**
     * 申请奖学金
     */
    @ResponseBody
    @RequestMapping(value = "/add_scholarship", method = RequestMethod.POST)
    public String addScholarship(@RequestParam String reason,
                                   @RequestParam Integer stuId,@RequestParam String stuName,
                                 @RequestParam Integer reviewId,@RequestParam String scopeType){

        Scholarship scholarship = new Scholarship();

        scholarship.setReason(reason);
        scholarship.setTeaId(reviewId);
        scholarship.setApplyForDate(new Date());
        scholarship.setStuId(stuId);
        scholarship.setState("0");
        scholarship.setStuName(stuName);
        scholarship.setScopeType(scopeType);
        applicationAndReviewServer.addScholarship(scholarship);
        return "申请成功";
    }

    /**
     * 学生版查看奖学金状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_scholarship", method = RequestMethod.POST)
    public List<Scholarship> selectscholarship(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectScholarship(applicatId);
    }
//    申请贫困生
//    查看申请状态
    /**
     * 申请贫困生
     */
    @ResponseBody
    @RequestMapping(value = "/add_poor", method = RequestMethod.POST)
    public String addPoor(@RequestParam String reason,@RequestParam Integer singleParent,
                                 @RequestParam Integer stuId,@RequestParam String stuName,
                                 @RequestParam Integer reviewId,@RequestParam Integer subsidy){

        Poor poor = new Poor();

        poor.setReason(reason);
        poor.setTeaId(reviewId);
        poor.setApplyForDate(new Date());
        poor.setStuId(stuId);
        poor.setState("0");
        poor.setStuName(stuName);
        poor.setSingleParent(singleParent);
        poor.setSubsidy(subsidy);
        applicationAndReviewServer.addPoor(poor);
        return "申请成功";
    }

    /**
     * 学生版查看贫困生
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/select_poor", method = RequestMethod.POST)
    public List<Poor> selectPoor(@RequestParam Integer applicatId){
        return applicationAndReviewServer.selectPoor(applicatId);
    }
//excel添加成绩
    @RequestMapping(value = "/add_excel_score", method = RequestMethod.POST)
    public String addexcel(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String test =  applicationAndReviewServer.addexcelScore(fileName, file);
        System.out.println("test="+test);
        return test;
    }
//    教师查看班级成绩
@ResponseBody
@RequestMapping(value = "/select_class_score", method = RequestMethod.POST)
    public List<Score> selectClassScore(){
    System.out.println("你猜");
        return applicationAndReviewServer.selectClassScore();

    }
//    班级成绩对比
@ResponseBody
@RequestMapping(value = "/select_classs_score", method = RequestMethod.POST)
public List<Score> selectClasssScore(@RequestParam Integer classId,@DateTimeFormat(pattern="yyyy-MM-dd") Date scoreDate){
    return applicationAndReviewServer.selectClasssScore(classId, scoreDate);

}
//批量删除成绩
        @ResponseBody
        @RequestMapping(value = "/delete_scores", method = RequestMethod.POST)
    public void  deleteScores(@RequestParam Integer [] scoreId){
applicationAndReviewServer.deleteScores(scoreId);
    }
    //删除成绩
    @ResponseBody
    @RequestMapping(value = "/delete_score", method = RequestMethod.POST)
    public void  deleteScore(@RequestParam Integer scoreId){
applicationAndReviewServer.deleteScore(scoreId);
    }


    //excel添加量化
    @RequestMapping(value = "/add_excel_quan", method = RequestMethod.POST)
    public String addexcelQuan(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String test =  applicationAndReviewServer.addexcelQuan(fileName, file);
        System.out.println("test="+test);
        return test;
    }

    //批量删除量化
    @ResponseBody
    @RequestMapping(value = "/delete_quans", method = RequestMethod.POST)
    public void  deleteQuans(@RequestParam Integer [] scoreId){
applicationAndReviewServer.deleteQuans(scoreId);
    }
    //删除量化
    @ResponseBody
    @RequestMapping(value = "/delete_quan", method = RequestMethod.POST)
    public void  deleteQuan(@RequestParam Integer quanId){
applicationAndReviewServer.deleteQuan(quanId);
    }
//    审核奖学金

    /**
     * 教师查看贫困生申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_poor", method = RequestMethod.POST)
    public List<Poor> teacherPoor(@RequestParam Integer applicatId){

        return applicationAndReviewServer.teacherPoor(applicatId);
    }
    /**
     * 教师查看奖学金申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_scholarship", method = RequestMethod.POST)
    public List<Scholarship> teacherScholarship(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherScholarship(applicatId);
    }
    /**
     * 教师查看换班申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_application_class", method = RequestMethod.POST)
    public List<ApplicationClass> teacherApplicationClass(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherApplicationClass(applicatId);
    }
    /**
     * 教师查看换宿申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_application_dorm", method = RequestMethod.POST)
    public List<ApplicationDorm> teacherApplicationDorm3(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherApplicationDorm3(applicatId);
    }
    /**
     * 一审教师查看请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_one_application_leave3", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherOneApplicationLeave(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherOneApplicationLeave(applicatId);
    }
    /**
     * 二审教师查看请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_two_application_leave3", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherTwoApplicationLeave(@RequestParam Integer applicatId){
        System.out.println(applicatId);
        return applicationAndReviewServer.teacherTwoApplicationLeave(applicatId);
    }
    /**
     * 三审教师查看请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_three_application_leave3", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherThreeApplicationDorm(@RequestParam Integer applicatId){
        System.out.println(applicatId);
        return applicationAndReviewServer.teacherThreeApplicationDorm(applicatId);
    }



    /**
     * 教师查看已审核贫困生申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_poor6", method = RequestMethod.POST)
    public List<Poor> teacherPoor6(@RequestParam Integer applicatId){

        return applicationAndReviewServer.teacherPoor6(applicatId);
    }
    /**
     * 教师查看已审核奖学金申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_scholarship6", method = RequestMethod.POST)
    public List<Scholarship> teacherScholarship6(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherScholarship6(applicatId);
    }
    /**
     * 教师查看已审核换班申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_application_class6", method = RequestMethod.POST)
    public List<ApplicationClass> teacherApplicationClass6(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherApplicationClass6(applicatId);
    }
    /**
     * 教师查看已审核换宿申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_application_dorm6", method = RequestMethod.POST)
    public List<ApplicationDorm> teacherApplicationDorm6(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherApplicationDorm6(applicatId);
    }
    /**
     * 一审教师查看已审核请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_one_application_leave6", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherOneApplicationLeave6(@RequestParam Integer applicatId){
        return applicationAndReviewServer.teacherOneApplicationLeave6(applicatId);
    }
    /**
     * 二审教师查看已审核请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_two_application_leave6", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherTwoApplicationLeave6(@RequestParam Integer applicatId){
        System.out.println(applicatId);
        return applicationAndReviewServer.teacherTwoApplicationLeave6(applicatId);
    }
    /**
     * 三审教师查看已审核请假申请状态
     * @param applicatId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/teacher_three_application_leave6", method = RequestMethod.POST)
    public List<ApplicationLeave> teacherThreeApplicationDorm6(@RequestParam Integer applicatId){
        System.out.println(applicatId);
        return applicationAndReviewServer.teacherThreeApplicationDorm6(applicatId);
    }
    /**
     * 审核奖学金
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_scholarship", method = RequestMethod.POST)
    public String updateScholarship(@RequestParam Integer poorId,@RequestParam String state,@RequestParam String review_reason){
        Scholarship applicationClass = new Scholarship();
        applicationClass.setScholarshipId(poorId);
        applicationClass.setState(state);
        applicationClass.setReviewReason(review_reason);
        applicationClass.setReviewDate(new Date());
        applicationAndReviewServer.updateScholarship(applicationClass);
        return "已审核";
    }
//    审核贫困生
    /**
     * 审核贫困生
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_poor", method = RequestMethod.POST)
    public String updatePoor(@RequestParam Integer poorId,@RequestParam String state,@RequestParam String review_reason){
        Poor applicationClass = new Poor();
        applicationClass.setPoorId(poorId);
        applicationClass.setState(state);
        applicationClass.setReviewReason(review_reason);
        applicationClass.setReviewDate(new Date());
        applicationAndReviewServer.updatePoor(applicationClass);
        return "已审核";
    }
//    审核请假
    /**
     * 审核请假
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_one_application_leave", method = RequestMethod.POST)
    public String updateOneApplicationLeave(@RequestParam Integer alId,@RequestParam String state,@RequestParam String review_reason){
        ApplicationLeave applicationClass = new ApplicationLeave();
        applicationClass.setAlId(alId);
        applicationClass.setState(state);
        applicationClass.setOneReviewReason(review_reason);
        applicationClass.setOneReviewDate(new Date());
        applicationAndReviewServer.updateOneApplicationLeave(applicationClass);
        return "已审核";
    }
    /**
     * 二审审核请假
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_two_application_leave", method = RequestMethod.POST)
    public String updateTwoApplicationLeave(@RequestParam Integer alId,@RequestParam String state,@RequestParam String review_reason){
        ApplicationLeave applicationClass = new ApplicationLeave();
        applicationClass.setAlId(alId);
        applicationClass.setState(state);
        applicationClass.setTwoReviewReason(review_reason);
        applicationClass.setTwoReviewDate(new Date());
        System.out.println(applicationClass);
        applicationAndReviewServer.updateTwoApplicationLeave(applicationClass);
        return "已审核";
    }
    /**
     * 三审审核请假
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_three_application_leave", method = RequestMethod.POST)
    public String updateThreeApplicationLeave(@RequestParam Integer alId,@RequestParam String state,@RequestParam String review_reason){
        ApplicationLeave applicationClass = new ApplicationLeave();
        applicationClass.setAlId(alId);
        applicationClass.setState(state);
        applicationClass.setThreeReviewReason(review_reason);
        applicationClass.setThreeReviewDate(new Date());
        applicationAndReviewServer.updateThreeApplicationLeave(applicationClass);
        return "已审核";
    }
//    审核换宿
    /**
     * 审核换宿
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_applicat_dorm", method = RequestMethod.POST)
    public String updateApplicatDorm(@RequestParam Integer laId,@RequestParam String state,@RequestParam String review_reason){
        ApplicationDorm applicationClass = new ApplicationDorm();
        applicationClass.setLaId(laId);
        applicationClass.setState(state);
        applicationClass.setReviewReason(review_reason);
        applicationClass.setReviewDate(new Date());
        applicationAndReviewServer.updateApplicatDorm(applicationClass);
        return "已审核";
    }
//    审核换班
    /**
     * 审核换班
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update_application_class", method = RequestMethod.POST)
    public String updateApplicationClass(@RequestParam Integer caId,@RequestParam String state,@RequestParam String review_reason){
        ApplicationClass applicationClass = new ApplicationClass();
        applicationClass.setCaId(caId);
        applicationClass.setState(state);
        applicationClass.setReviewReason(review_reason);
        applicationClass.setReviewDate(new Date());
        System.out.println(applicationClass);
        applicationAndReviewServer.updateApplicationClass(applicationClass);

        return "已审核";
    }

}
