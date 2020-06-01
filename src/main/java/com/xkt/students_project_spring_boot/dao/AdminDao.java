package com.xkt.students_project_spring_boot.dao;

import com.xkt.students_project_spring_boot.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface AdminDao {
    /**
     * 管理员登录
     * @param adminID
     * @param password
     * @return
     */
    Admin findByIdAndByPassword(Integer adminID,String password);

    /**
     * 查看所有公告
     * @return
     */
    List<Notice> findNoticeAll();
//    批量删除
    void deleteBathesNotice(Integer[] notice_id);

    /**
     * 删除单条公告
     * @param noticeId
     */
    void deleteNotice(Integer noticeId);
    Integer [] selectBathesNotice(Integer[] array);
/**
 *     插入单条公告
  */
    void insertNoter(Notice notice);

    //excel导入
    void addStudent(Student student);
    String selectStudentId(Integer stuId);
    void addPatriarch(Patriarch patriarch);
    Integer selectPatriarch(Integer patId);
    void addTeacher(Teacher teacher);
    Integer selectTeacher(Integer teaId);

//    查看所有未注销学生用户
    List<Student> findStudentAll();
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
//    查看所有家长
    List<Patriarch> findPatriarchAll();

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
//    查看所有教师用户
    List<Teacher> findTeacherAll();

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
    String updatePatriarchPassword(Integer stuId,String password);
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
    String updateTeacherPassword(Integer stuId,String password);

    /**
     * 修改教师权限
     * @param teacher_id
     * @param autority
     */
    void teacherAutority(Integer teacher_id,Integer autority);
}
