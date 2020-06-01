package com.xkt.students_project_spring_boot;

import com.xkt.students_project_spring_boot.dao.*;
import com.xkt.students_project_spring_boot.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentsProjectSpringBootApplication.class)
class StudentsProjectSpringBootApplicationTests {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private PatriarchDao patriarchDao;
    @Autowired
    private ApplicationAndReviewDao applicationAndReview;
    @Autowired
    private TeacherDao teacherDao;
    @Test
    void contextLoads() {

        List<Notice> list = adminDao.findNoticeAll();
        System.out.println(list.size());
        for (Notice temp : list) {
            System.out.println(temp);
        }
    }
    @Test
    public void deleteBathesNotice(){
        Integer array[] = new Integer []{16,17};
        adminDao.deleteBathesNotice(array);
    }
    @Test
    public void insertNoter(){
        Notice notice = new Notice();
        notice.setAuthor("wttya");
        notice.setNoticeBody("akjshdfgbidhfsadj");
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        notice.setNoticeDate(new Date());
        notice.setNoticeTitle("asgdfy");
        notice.setNoticeType("班级公告");
        adminDao.insertNoter(notice);
    }
    @Test
    public void test(){
        System.out.println(new Date());
    }
    @Test
    public void selectId() {
        System.out.println(adminDao.selectStudentId(2016060));
        try {
            System.out.println(adminDao.selectStudentId(2016060));
        } catch (Exception e) {
            System.out.println("没找着");
        }
    }
    /**
     * 删除公告
     */
    @Test
    public void deleteNotice(){
        adminDao.deleteNotice(18);
    }
    @Test
    public void Login(){

//        Student admin1 = adminDao.studentFindByIdAndByPassword(2016061,"aaa");
        Student admin1 = studentDao.findByIdAndByPassword(2016060,"qqq");
        System.out.println(admin1);
    }

    @Test
    public void findStudentAll(){
        List<Teacher>  list = adminDao.findTeacherAll();
        for (Teacher student : list){
            System.out.println(student);
        }
//        List<Patriarch>  list1 = adminDao.findRuinPatriarchAll();
//        for (Patriarch student : list1){
//            System.out.println("hhh");
//            System.out.println(student);
//        }
    }
    @Test
    void findRuinTeacher(){
        Integer [] a = new Integer[2];
        a[0] = 1;
        a[1] = 2;
            adminDao.logoutTeachers(a);
    }

    @Test
    void studentScores(){
//        List<Score> list= applicationAndReview.studentScores(1);
//
//        for (Score score : list){
//            System.out.println(score);
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = "2020-05-18";
//        try {
//            Date date_ = sdf.parse(date);// 将字符串转化为时间格式
//            System.out.println(date);
//            List<Score> list = applicationAndReview.studentTimeScore(1,date);
//            System.out.println(list.size());
//                    for (Score score : list) {
//                        System.out.println(score);
//                    }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String date = "2020-05-10";
        String date1 = "2020-05-17";
        List<Score> list = applicationAndReview.studentTimesScore(1,date,date1,"a");
        System.out.println(list.size());
        for (Score score : list) {
            System.out.println(score);
        }
    }
    @Test
    public void updatePassword(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1);
        teacher.setPassword("123456");
        teacherDao.updateTeacher(teacher);
    }
    @Test
    void deleteScore(){
        Integer a [] = new Integer[]{6,7};
        teacherDao.deleteBathesScore(a);
    }
    @Test
    void ttt(){
        ApplicationLeave applicationLeave = new ApplicationLeave();
        applicationLeave.setAlId(1);
        applicationLeave.setState("1");
        applicationLeave.setOneReviewId(1);
        applicationLeave.setOneReviewReason("a");
        teacherDao.updateOneApplicatLeave(applicationLeave);
    }
    @Test
    void hhh(){
//        applicationAndReview.studentTimesScore();
//        teacherDao.updateOneApplicatLeave(applicationLeave);
        Student student;
        System.out.println("学生");
        student = studentDao.findByIdAndByPassword(2016061,"aaa");
        System.out.println(student);
        Patriarch patriarch;
        System.out.println("家长");
        patriarch = patriarchDao.findByIdAndByPassword(201606012,"a123456");
        System.out.println(patriarch);
    }
    @Test
    public void a(){
//        ApplicationLeave applicationLeave = new ApplicationLeave();
//        applicationLeave.setReason("就想请个假");
//        applicationLeave.setApplicationId(201606012);
//        applicationLeave.setApplicationDate(new Date());
//        applicationLeave.setDays(2);
//        applicationLeave.setOneReviewId(12345671);
//        applicationLeave.setStuId(2016060);
//        applicationLeave.setStuName("wtt");
//        applicationLeave.setTwoReviewId(12345678);
//        applicationLeave.setThreeReviewId(12345679);
//        applicationAndReview.addApplicatLeave(applicationLeave);
        List<ApplicationDorm> list = applicationAndReview.selectApplicationDorm(201606012);
        for (ApplicationDorm applicationDorm : list){
            System.out.println(applicationDorm);
        }
    }
}
