package com.xkt.students_project_spring_boot.controller;


import com.xkt.students_project_spring_boot.dao.AdminDao;
import com.xkt.students_project_spring_boot.domain.Notice;
import com.xkt.students_project_spring_boot.domain.Patriarch;
import com.xkt.students_project_spring_boot.domain.Student;
import com.xkt.students_project_spring_boot.domain.Teacher;
import com.xkt.students_project_spring_boot.service.AdminServer;
import com.xkt.students_project_spring_boot.service.Impl.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("user")
public class QuickStartController {
    @Autowired
    private AdminServerImpl adminServer;
    @Autowired
    private StudentServerImpl studentServer;
    @Autowired
    private PatriarchServerImpl patriarchServer;
    @Autowired
    private TeacherServerImpl teacherServer;
    @Autowired
    private ApplicationAndReviewServerImpl applicationAndReviewServer1;
/**
 *
 登录
  */
@ResponseBody
@RequestMapping(value = "/login", method = RequestMethod.POST)
public Object login( @RequestParam Integer username, @RequestParam String password){
    Map<String,Object> result = new HashMap<String, Object>();

    if(username.toString().length()==6 && adminServer.findByIdAndByPassword(username, password)!=null) {
        result.put("code", 200);
        result.put("msg", "登录成功");
        result.put("token", "admin");
        return result;
    } else if(username.toString().length()==7 && studentServer.findByIdAndByPassword(username, password)!=null) {
        Student student = studentServer.findByIdAndByPassword(username, password);
        System.out.println("jjjjj");
        result.put("code", 200);
        result.put("msg", "登录成功");
        result.put("token", "student");
        result.put("class_token",student.getClassId());
        result.put("stu_id",student.getStuId());
        return result;
    }else if(username.toString().length()==8 && teacherServer.findByIdAndByPassword(username, password)!=null) {
        System.out.println("ttt");
        result.put("code", 200);
        result.put("msg", "登录成功");
        result.put("token", "teacher");
        result.put("autority",teacherServer.findByIdAndByPassword(username, password).getAutority());
        return result;
    }else if(username.toString().length()==9 && patriarchServer.findByIdAndByPassword(username, password)!=null) {
        Patriarch patriarch = patriarchServer.findByIdAndByPassword(username, password);
        System.out.println(patriarch+"ashdgkdujfh");
//       家长在写一个由学生di查找班级id的语句，然后传到result中
        System.out.println("ppp");
        result.put("code", 200);
        result.put("msg", "登录成功");
        result.put("token", "patriarch");
        System.out.println("家长"+patriarch.getStuId());
        result.put("stu_id",patriarch.getStuId());
        return result;
    }


    result.put("code", 500);
    result.put("msg", "登录失败");
    return result;
}



    /**
     * 查看所有公告
     */
    @ResponseBody
    @RequestMapping(value = "/select_admin_notice", method = RequestMethod.POST)
    public List<Notice> selectAdminNotice(){
        return adminServer.findNoticeAll();
    }

    //    批量删除公告
    @ResponseBody
    @RequestMapping(value = "/delete_bathes_notice", method = RequestMethod.POST)
    public String deleteBathesNotice(@RequestParam Integer[] params){
        for (int i= 0;i<params.length;i++)
            System.out.println(params[i]);
        adminServer.deleteBathesNotice(params);
        return "删除成功";
    }
/**
 *  删除公告
 */
    @ResponseBody
    @RequestMapping(value = "/delete_notice", method = RequestMethod.POST)
    public String deleteNotice(@RequestParam Integer row){
        System.out.println(row);
        adminServer.deleteNotice(row);
        return "删除成功";
    }

    /**
     * 添加excel用户（学生，家长，教师）
     * @param file
     * @return
     * @throws Exception
     */
//    @RequestBody
    @RequestMapping(value = "/insert_excel", method = RequestMethod.POST)
    public String addexcel(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String test =  adminServer.batchImport(fileName, file);
        System.out.println("test="+test);
        return test;
//        return null;
    }

    /**
     * 添加用户
     * @param student
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/insert_user", method = RequestMethod.POST)
    public String addUser(@RequestParam Student student) throws Exception {

//        String test =  adminServer.batchImport(fileName, file);
//        System.out.println("test="+test);
//        return test;
        return null;
    }
    /**
     * 添加公告
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/insert_notice", method = RequestMethod.POST)
    public String addNotice(@RequestParam String noticeTitle ,@RequestParam String noticeAuthor, @RequestParam String noticeBody, @RequestParam String noticeType ) throws Exception {
        Notice notice = new Notice();
        notice.setNoticeTitle(noticeTitle);
        notice.setAuthor(noticeAuthor);
        notice.setNoticeBody(noticeBody);
        notice.setNoticeType(noticeType);
        System.out.println(notice);
        adminServer.insertNoter(notice);
        return "添加成功";
    }


    /**
     *修改用户密码
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    public String updateUserPassword(@RequestParam  Integer username,@RequestParam  String password) throws Exception {
        System.out.println(username);
        int a = username.toString().length();
        if (a==7){
            adminServer.updateStudentPassword(username,password);
        }else if (a==8){
            adminServer.updateTeacherPassword(username, password);
        }else
            adminServer.updatePatriarchPassword(username, password);

        return "修改成功";
    }

    /**
     * 修改教师权限
     * @param username
     * @param autority
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update_teacher_autority", method = RequestMethod.POST)
    public String updateTheacher(@RequestParam  Integer username,@RequestParam  Integer autority) throws Exception {
        adminServer.teacherAutority(username,autority);
        return "修改成功";
    }
    /**
     * 查看所有学生
     */
    @ResponseBody
    @RequestMapping(value = "/find_student_all", method = RequestMethod.POST)
    public List<Student> findStudentAll(){
        return adminServer.findStudentAll();
    }
    //    批量注销
    @ResponseBody
    @RequestMapping(value = "/ruin_bathes_student", method = RequestMethod.POST)
    public String ruinBathesStudent(@RequestParam Integer[] params){
        adminServer.logoutStudents(params);
        return "注销成功";
    }
    /**
     *  注销学生
     */
    @ResponseBody
    @RequestMapping(value = "/ruin_student", method = RequestMethod.POST)
    public String ruinStudent(@RequestParam Integer row){
        adminServer.logoutStudent(row);
        return "注销成功";
    }
    /**
     * 查看所有注销学生
     */
    @ResponseBody
    @RequestMapping(value = "/find_ruin_student_all", method = RequestMethod.POST)
    public List<Student> findRuinStudentAll(){
        return adminServer.findRuinStudentAll();
    }
    //    批量删除
    @ResponseBody
    @RequestMapping(value = "/delete_bathes_student", method = RequestMethod.POST)
    public String deleteBathesStudent(@RequestParam Integer[] params){
        adminServer.deleteStudents(params);
        return "删除成功";
    }
    /**
     *  删除学生
     */
    @ResponseBody
    @RequestMapping(value = "/delete_student", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam Integer row){
        adminServer.deleteStudent(row);
        return "删除成功";
    }
    /**
     * 查看所有家长
     */
    @ResponseBody
    @RequestMapping(value = "/find_patriarch_all", method = RequestMethod.POST)
    public List<Patriarch> findPatriarchAll(){
        return adminServer.findPatriarchAll();
    }
    //    批量注销
    @ResponseBody
    @RequestMapping(value = "/ruin_bathes_patriarch", method = RequestMethod.POST)
    public String ruinBathesPatriarch(@RequestParam Integer[] params){
        adminServer.logoutPatriarchs(params);
        return "注销成功";
    }
    /**
     *  注销家长
     */
    @ResponseBody
    @RequestMapping(value = "/ruin_patriarch", method = RequestMethod.POST)
    public String ruinPatriarch(@RequestParam Integer row){
        adminServer.logoutPatriarch(row);
        return "注销成功";
    }
    /**
     * 查看所有注销家长
     */
    @ResponseBody
    @RequestMapping(value = "/find_ruin_patriarch_all", method = RequestMethod.POST)
    public List<Patriarch> findRuinPatriarchAll(){
        return adminServer.findRuinPatriarchAll();
    }
    //    批量删除
    @ResponseBody
    @RequestMapping(value = "/delete_bathes_patriarch", method = RequestMethod.POST)
    public String deleteBathesPatriarch(@RequestParam Integer[] params){
        adminServer.deletePatriarchs(params);
        return "删除成功";
    }
    /**
     *  删除家长
     */
    @ResponseBody
    @RequestMapping(value = "/delete_patriarch", method = RequestMethod.POST)
    public String deletePatriarch(@RequestParam Integer row){
        adminServer.deletePatriarch(row);
        return "删除成功";
    }
    /**
     * 查看所有教师
     */
    @ResponseBody
    @RequestMapping(value = "/find_teacher_all", method = RequestMethod.POST)
    public List<Teacher> findTeacherAll(){
        return adminServer.findTeacherAll();
    }
    //    批量注销
    @ResponseBody
    @RequestMapping(value = "/ruin_bathes_teacher", method = RequestMethod.POST)
    public String ruinBathesTeacher(@RequestParam Integer[] params){
        adminServer.logoutTeachers(params);
        return "注销成功";
    }
    /**
     *  注销教师
     */
    @ResponseBody
    @RequestMapping(value = "/ruin_teacher", method = RequestMethod.POST)
    public String ruinTeacher(@RequestParam Integer row){
        adminServer.logoutTeacher(row);
        return "注销成功";
    }
    /**
     * 查看所有注销教师
     */
    @ResponseBody
    @RequestMapping(value = "/find_ruin_teacher_all", method = RequestMethod.POST)
    public List<Teacher> findRuinTeacherAll(){
        return adminServer.findRuinTeacherAll();
    }
    //    批量删除
    @ResponseBody
    @RequestMapping(value = "/delete_bathes_teacher", method = RequestMethod.POST)
    public String deleteBathesTeacher(@RequestParam Integer[] params){
        adminServer.deleteTeachers(params);
        return "删除成功";
    }
    /**
     *  删除教师
     */
    @ResponseBody
    @RequestMapping(value = "/delete_teacher", method = RequestMethod.POST)
    public String deleteTeacher(@RequestParam Integer row){
        adminServer.deleteTeacher(row);
        return "删除成功";
    }
}
