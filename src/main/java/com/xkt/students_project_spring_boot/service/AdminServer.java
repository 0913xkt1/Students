package com.xkt.students_project_spring_boot.service;


import com.xkt.students_project_spring_boot.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminServer {

    /**
     * 管理员登录
     * @param adminId
     * @param password
     * @return
     */
    public Admin findByIdAndByPassword(Integer adminId,String password);
    /**
     * 查看所有订单
     * @return
     */
    public List<Notice> findNoticeAll();

    /**
     * 批量删除公告
     * @param array
     */
    void deleteBathesNotice(Integer[] array);
    /**
     * 删除公告
     * @param noticeId
     */
    void deleteNotice(Integer noticeId);

    /**
     * 查看所有学生
     * @return
     */
    List<Student> findStudentAll();

    /**
     * 查看所有家长
     * @return
     */
     List<Patriarch> findPatriarchAll() ;

    /**
     * 查看所有教师
     * @return
     */
     List<Teacher> findTeacherAll();

    /**
     * 导入excel
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    String batchImport(String fileName, MultipartFile file) throws Exception;


    /**
     *  查看已注销学生用户
     */
    List<Student> findRuinStudentAll();
    /**
     * 批量注销学生
     */
    void logoutStudents(Integer [] student_id);
    /**
     * 注销学生
     */
    void logoutStudent(Integer student_id);
    /**
     * 批量删除学生
     */
    void deleteStudents(Integer [] student_id);
    /**
     *删除学生
     */
    void deleteStudent(Integer student_id);


    /**
     * 查看所有已注销家长
     * @return
     */
    List<Patriarch> findRuinPatriarchAll();
    /**
     * 批量注销家长
     */
    void logoutPatriarchs(Integer [] pat_id);
    /**
     * 注销家长
     */
    void logoutPatriarch(Integer pat_id);
    /**
     * 批量删除家长
     */
    void deletePatriarchs(Integer [] pat_id);

    /**
     * 删除家长
     */
    void deletePatriarch(Integer pat_id);


    /**
     * 查看已注销教师
     * @return
     */
    List<Teacher> findRuinTeacherAll();
    /**
     * 批量注销教师
     */
    void logoutTeachers(Integer [] a);
    /**
     * 注销教师
     */
    void logoutTeacher(Integer a);
    /**
     * 批量删除教师
     */
    void deleteTeachers(Integer [] teacher_id);

    /**
     * 删除教师
     */
    void deleteTeacher(Integer teacher_id);
    /**
     * 批量取消学生注销状态
     * @param stuId
     * @return
     */
    void revocerStudents(Integer[] stuId);
    /**
     * 取消学生注销状态
     * @param stuId
     * @return
     */
    void revocerStudent(Integer stuId);

    /**
     * 添加公告
     * @param notice
     */
    void insertNoter(Notice notice);

    /**
     * 更改学生密码
     * @param stuId
     * @param password
     * @return
     */
    void updateStudentPassword(Integer stuId,String password);
    /**
     * 批量取消家长注销状态
     * @param patId
     * @return
     */
    Integer revocerPatriarchs(Integer [] patId);
    /**
     * 取消家长注销状态
     * @param patId
     * @return
     */
    Integer revocerPatriarch(Integer patId);

    /**
     * 更改家长密码
     * @param stuId
     * @param password
     * @return
     */
    void updatePatriarchPassword(Integer stuId,String password);
    /**
     * 取消学生注销状态
     * @param teaId
     * @return
     */
    void revocerTeachers(Integer[] teaId);
    /**
     * 取消教师注销状态
     * @param teaId
     * @return
     */
    Integer revocerTeacher(Integer teaId);

    /**
     * 更改教师密码
     * @param stuId
     * @param password
     * @return
     */
    void updateTeacherPassword(Integer stuId,String password);
    /**
     * 修改教师权限
     * @param teacher_id
     * @param autority
     */
    void teacherAutority(Integer teacher_id,Integer autority);

}
