package com.xkt.students_project_spring_boot.service.Impl;


import com.xkt.students_project_spring_boot.dao.AdminDao;
import com.xkt.students_project_spring_boot.domain.*;
import com.xkt.students_project_spring_boot.service.AdminServer;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServerImpl implements AdminServer {

    @Autowired
    public AdminDao adminDao;


    @Override
    public Admin findByIdAndByPassword(Integer adminId, String password) {
        return adminDao.findByIdAndByPassword(adminId, password);
    }

    @Override
    public List<Notice> findNoticeAll() {
        return adminDao.findNoticeAll();
    }

    @Override
    public void deleteBathesNotice(Integer[] array) {
        adminDao.deleteBathesNotice(array);
    }

    @Override
    public void deleteNotice(Integer noticeId) {
        adminDao.deleteNotice(noticeId);
    }

    @Override
    public List<Student> findStudentAll() {
        return adminDao.findStudentAll();
    }

    @Override
    public List<Patriarch> findPatriarchAll() {
        return adminDao.findPatriarchAll();
    }

    @Override
    public List<Teacher> findTeacherAll() {
        return adminDao.findTeacherAll();
    }

    /**
     * excel导入
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String batchImport(String fileName, MultipartFile file) throws Exception {

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        List<Student> students = new ArrayList<>();
        try {
            InputStream is = file.getInputStream();
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(is));
            //有多少个sheet
            int sheets = workbook.getNumberOfSheets();

            for (int i = 0; i < sheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                //获取多少行
                int rows = sheet.getPhysicalNumberOfRows();

                Student student = null;
                //遍历每一行，注意：第 0 行为标题
                System.out.println("1234456576879");
                System.out.println("进入遍历方法");

                for (int j = 1; j < rows; j++) {


                    //获得第 j 行
                    HSSFRow row = sheet.getRow(j);
                    student = new Student();

                    if (row.getCell(0).getStringCellValue().equals("学生")) {
                        System.out.println("row=" + row);
                        student.setStuId((int) row.getCell(1).getNumericCellValue());
                        System.out.println("学号=" + student.getStuId());
                        student.setPassword(row.getCell(2).getStringCellValue());
                        System.out.println("密码=" + student.getClassId());
                        student.setClassId((int) row.getCell(3).getNumericCellValue());
                        System.out.println("班级号=" + student.getClassId());
                        student.setGrade(row.getCell(4).getStringCellValue());
                        System.out.println("年级=" + student.getGrade());
                        student.setDormId((int) row.getCell(5).getNumericCellValue());
                        System.out.println("宿舍号=" + student.getDormId());
                        student.setSingleParent((int) row.getCell(6).getNumericCellValue());
                        System.out.println("是否有国家补助=" + student.getSingleParent());
                        student.setSubsidy((int) row.getCell(7).getNumericCellValue());
                        System.out.println("是否单亲=" + student.getSubsidy());
                        student.setPatriarchId((int) row.getCell(8).getNumericCellValue());
                        System.out.println("家长号=" + student.getPatriarchId());
                        student.setSex(row.getCell(9).getStringCellValue());
                        System.out.println("性别=" + student.getSex());
                        student.setStuName(row.getCell(10).getStringCellValue());
                        System.out.println("姓名=" + student.getStuName());


                        students.add(student);
                        try{
                            adminDao.selectStudentId(student.getStuId());
                            adminDao.addStudent(student);
                            System.out.println("----------------");
                        }catch (Exception e){
                            continue;
                        }

                    } else if (row.getCell(0).getStringCellValue().equals("家长")) {
                        Patriarch patriarch = new Patriarch();
                        patriarch.setPatId((int) row.getCell(1).getNumericCellValue());
                        System.out.println("家长编号=" + patriarch.getPatId());
                        patriarch.setPassword(row.getCell(2).getStringCellValue());
                        System.out.println("密码=" + patriarch.getPassword());
                        patriarch.setStuId((int) row.getCell(3).getNumericCellValue());
                        System.out.println("学号=" + patriarch.getStuId());
                        patriarch.setPatName(row.getCell(4).getStringCellValue());
                        System.out.println("姓名=" + patriarch.getPatName());
                        Double aaa = row.getCell(5).getNumericCellValue();
                        patriarch.setCellPhoneNumber(aaa.toString());
                        System.out.println("手机号=" + patriarch.getCellPhoneNumber());
                        patriarch.setSex(row.getCell(6).getStringCellValue());
                        System.out.println("性别=" + patriarch.getSex());
                        try{
                            adminDao.selectPatriarch(patriarch.getPatId());
                            adminDao.addPatriarch(patriarch);
                            System.out.println("----------------");
                        }catch (Exception e){
                            continue;
                        }
                    } else if (row.getCell(0).getStringCellValue().equals("教师")) {
                        Teacher teacher = new Teacher();
                        teacher.setTeacherId((int) row.getCell(1).getNumericCellValue());
                        System.out.println("职工号=" + teacher.getTeacherId());
                        teacher.setPassword(row.getCell(2).getStringCellValue());
                        System.out.println("密码=" + teacher.getPassword());
                        teacher.setAutority((int) row.getCell(3).getNumericCellValue());
                        System.out.println("权限=" + teacher.getAutority());
                        teacher.setGrade(row.getCell(4).getStringCellValue());
                        System.out.println("年级=" + teacher.getGrade());
                        teacher.setTeacherName(row.getCell(5).getStringCellValue());
                        System.out.println("姓名=" + teacher.getTeacherName());
                        try{
                            adminDao.selectTeacher(teacher.getTeacherId());
                            adminDao.addTeacher(teacher);
                            System.out.println("----------------");
                        }catch (Exception e){
                            continue;
                        }
                    } else
                        return "导入数据类型错误，检查上传文件";
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "导入数据格式有误，请检查上传文件";
        }
        return "导入数据成功";
    }

    @Override
    public List<Student> findRuinStudentAll() {
        return adminDao.findRuinStudentAll();
    }

    @Override
    public void logoutStudents(Integer[] student_id) {
        adminDao.logoutStudents(student_id);
    }

    @Override
    public void logoutStudent(Integer student_id) {
        adminDao.logoutStudent(student_id);
    }

    @Override
    public void deleteStudents(Integer[] student_id) {
        adminDao.deleteStudents(student_id);
    }

    @Override
    public void deleteStudent(Integer student_id) {
        adminDao.deleteStudent(student_id);
    }

    @Override
    public List<Patriarch> findRuinPatriarchAll() {
        return adminDao.findRuinPatriarchAll();
    }

    @Override
    public void logoutPatriarchs(Integer[] pat_id) {
        adminDao.logoutPatriarchs(pat_id);
    }

    @Override
    public void logoutPatriarch(Integer pat_id) {
        adminDao.logoutPatriarch(pat_id);
    }

    @Override
    public void deletePatriarchs(Integer[] pat_id) {
        adminDao.deletePatriarchs(pat_id);
    }

    @Override
    public void deletePatriarch(Integer pat_id) {
        adminDao.deletePatriarch(pat_id);
    }

    @Override
    public List<Teacher> findRuinTeacherAll() {
        return adminDao.findRuinTeacherAll();
    }

    @Override
    public void logoutTeachers(Integer [] a) {
        adminDao.logoutTeachers(a);
    }

    @Override
    public void logoutTeacher(Integer a) {
        adminDao.logoutTeacher(a);
    }

    @Override
    public void deleteTeachers(Integer[] teacher_id) {
        adminDao.deleteTeachers(teacher_id);
    }

    @Override
    public void deleteTeacher(Integer teacher_id) {
        adminDao.deleteTeacher(teacher_id);
    }

    @Override
    public void revocerStudents(Integer[] stuId) {
        adminDao.revocerPatriarchs(stuId);
    }

    @Override
    public void revocerStudent(Integer stuId) {
        adminDao.revocerStudent(stuId);
    }

    @Override
    public void insertNoter(Notice notice) {
        adminDao.insertNoter(notice);
    }

    @Override
    public void updateStudentPassword(Integer stuId, String password) {
        adminDao.updateStudentPassword(stuId, password);
    }

    @Override
    public Integer revocerPatriarchs(Integer[] patId) {
        return adminDao.revocerPatriarchs(patId);
    }

    @Override
    public Integer revocerPatriarch(Integer patId) {
        return adminDao.revocerPatriarch(patId);
    }

    @Override
    public void updatePatriarchPassword(Integer stuId, String password) {
        adminDao.updatePatriarchPassword(stuId, password);
    }

    @Override
    public void revocerTeachers(Integer[] teaId) {
        adminDao.revocerTeachers(teaId);
    }

    @Override
    public Integer revocerTeacher(Integer teaId) {
        return adminDao.revocerTeacher(teaId);
    }

    @Override
    public void updateTeacherPassword(Integer stuId, String password) {
        adminDao.updateTeacherPassword(stuId,password);
    }

    @Override
    public void teacherAutority(Integer teacher_id, Integer autority) {
        adminDao.teacherAutority(teacher_id,autority);
    }

}
