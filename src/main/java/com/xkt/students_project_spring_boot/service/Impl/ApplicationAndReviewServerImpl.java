package com.xkt.students_project_spring_boot.service.Impl;

import com.xkt.students_project_spring_boot.dao.ApplicationAndReviewDao;
import com.xkt.students_project_spring_boot.domain.*;
import com.xkt.students_project_spring_boot.service.ApplicationAndReviewServer;
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
import java.util.Date;
import java.util.List;
@Service
public class ApplicationAndReviewServerImpl implements ApplicationAndReviewServer {
    @Autowired
    private ApplicationAndReviewDao applicationAndReviewDao;
    @Override
    public List<Score> studentScores(Integer stuId) {
        return applicationAndReviewDao.studentScores(stuId);
    }

    @Override
    public List<Score> studentTimeScore(Integer stuId, String scoreDate,String scoreName) {
        return applicationAndReviewDao.studentTimeScore(stuId, scoreDate, scoreName);
    }

    @Override
    public List<Score> studentTimesScore(Integer stuId, String scoreDate, String scoreDate1,String scoreName) {
        return applicationAndReviewDao.studentTimesScore(stuId, scoreDate, scoreDate1, scoreName);
    }

    @Override
    public List<Score> classScore(Integer class_id) {
        return applicationAndReviewDao.classScore(class_id);
    }

    @Override
    public List<Score> classTimeScore(Integer class_id, String scoreDate,String scoreName) {
        return applicationAndReviewDao.classTimeScore(class_id, scoreDate, scoreName);
    }

    @Override
    public List<Score> classTimesScore(Integer class_id, String scoreDate, String scoreDate1,String scoreName) {
        return applicationAndReviewDao.classTimeScore(class_id, scoreDate, scoreName);
    }

    @Override
    public List<Score> classContrastScore(String scoreDate,String scoreName) {
        return applicationAndReviewDao.classContrastScore(scoreDate, scoreName);
    }

    @Override
    public void addApplicatLeave(ApplicationLeave applicationLeave) {
applicationAndReviewDao.addApplicatLeave(applicationLeave);
    }

    @Override
    public List<ApplicationLeave> selectApplicationLeave(Integer applicatId) {
        return applicationAndReviewDao.selectApplicationLeave(applicatId);
    }

    @Override
    public List<ApplicationLeave> selectApplicationLeave1(Integer stuId) {
        return applicationAndReviewDao.selectApplicationLeave1(stuId);
    }

    @Override
    public void addApplicatClass(ApplicationClass applicationClass) {
        applicationClass.setWantClassId(applicationAndReviewDao.findStudentBystuId(applicationClass.getStuId()).getClassId());
        applicationAndReviewDao.addApplicatClass(applicationClass);
    }

    @Override
    public List<ApplicationClass> selectApplicationClass(Integer applicatId) {
        return applicationAndReviewDao.selectApplicationClass(applicatId);
    }

    @Override
    public List<ApplicationClass> selectApplicationClass1(Integer stuId) {
        return applicationAndReviewDao.selectApplicationClass1(stuId);
    }

    @Override
    public void addApplicatDorm(ApplicationDorm applicationDorm) {
        applicationDorm.setWantDormId(applicationAndReviewDao.findStudentBystuId(applicationDorm.getStuId()).getDormId());
        applicationAndReviewDao.addApplicatDorm(applicationDorm);
    }

    @Override
    public List<ApplicationDorm> selectApplicationDorm(Integer applicatId) {
        return applicationAndReviewDao.selectApplicationDorm(applicatId);
    }

    @Override
    public List<ApplicationDorm> selectApplicationDorm1(Integer stuId) {
        return applicationAndReviewDao.selectApplicationDorm1(stuId);
    }

    @Override
    public List<Quantification> selectQuans() {
        return applicationAndReviewDao.selectQuans();
    }

    @Override
    public List<Quantification> selectTimeQuans(Integer stu_id, String quanDate, String quanDate1) {
        return applicationAndReviewDao.selectTimeQuans(stu_id, quanDate, quanDate1);
    }

    @Override
    public void addPoor(Poor poor) {
        applicationAndReviewDao.addPoor(poor);
    }

    @Override
    public List<Poor> selectPoor(Integer stuId) {
        return applicationAndReviewDao.selectPoor(stuId);
    }

    @Override
    public void addScholarship(Scholarship poor) {
        applicationAndReviewDao.addScholarship(poor);
    }

    @Override
    public List<Scholarship> selectScholarship(Integer stuId) {
        return applicationAndReviewDao.selectScholarship(stuId);
    }

    @Override
    public void updateStudent(Student student) {
        applicationAndReviewDao.updateStudent(student);
    }

    @Override
    public void updatePatriarch(Patriarch patriarch) {
applicationAndReviewDao.updatePatriarch(patriarch);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
applicationAndReviewDao.updateTeacher(teacher);
    }

    @Override
    public List<Quantification> selectStudentQuan(Integer stu_id) {
        return applicationAndReviewDao.selectStudentQuan(stu_id);
    }

    /**
     * 有待修改
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addexcelScore(String fileName, MultipartFile file) throws Exception  {
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        List<Score> scores = new ArrayList<>();
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
                    Score score = new Score();

                    if (row.getCell(0).getStringCellValue().equals("成绩")) {
                        System.out.println("row=" + row);
                        score.setScore((Double) row.getCell(1).getNumericCellValue());
                        System.out.println("分数=" + score.getScore());
                        score.setStuName(row.getCell(2).getStringCellValue());
                        System.out.println("学生姓名=" + score.getStuName());
                        score.setScoreDate((Date) row.getCell(3).getDateCellValue());
                        System.out.println("考试时间=" + score.getScoreDate());
                        score.setClassId((int) row.getCell(4).getNumericCellValue());
                        System.out.println("班级号=" + score.getClassId());
                        score.setGrade(row.getCell(5).getStringCellValue());
                        System.out.println("年级=" + score.getGrade());
                        score.setScoreName(row.getCell(6).getStringCellValue());
                        System.out.println("科目=" + score.getScoreName());
                        score.setStuId((int) row.getCell(7).getNumericCellValue());
                        System.out.println("学号=" + score.getStuId());

                        scores.add(score);
                        try{
//                            applicationAndReviewDao.selectS(student.getStuId());
                            System.out.println("----------------");
                            applicationAndReviewDao.addexcelScore(score);
                            System.out.println("----------------");
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            continue;
                        }

                    } else if (row.getCell(0).getStringCellValue().equals("量化")) {
                        Quantification quan = new Quantification();
                        quan.setQuanDate(row.getCell(1).getDateCellValue());
                        System.out.println("量化如期=" + quan.getQuanDate());
                        quan.setStuId((int)row.getCell(2).getNumericCellValue());
                        System.out.println("xeuhao=" + quan.getStuName());
                        quan.setStuName(row.getCell(3).getStringCellValue());
                        System.out.println("姓名=" + quan.getStuName());
                        quan.setScore((Double) row.getCell(4).getNumericCellValue());
                        System.out.println("分数=" + quan.getScore());
                        quan.setReason(row.getCell(5).getStringCellValue());
                        System.out.println("理由=" + quan.getReason());
                        try{
                            applicationAndReviewDao.addexcelQuan(quan);
                            System.out.println("----------------");
                        }catch (Exception e){
                            continue;
                        }
                    }
                    else
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
    public List<Score> selectClassScore() {
        return applicationAndReviewDao.selectClassScore();
    }

    @Override
    public List<Score> selectClasssScore(Integer classId, Date scoreDate) {
        return applicationAndReviewDao.selectClasssScore(classId, scoreDate);
    }

    @Override
    public void deleteScores(Integer[] scoreId) {
        applicationAndReviewDao.deleteScores(scoreId);
    }

    @Override
    public void deleteScore(Integer scoreId) {
applicationAndReviewDao.deleteScore(scoreId);
    }

    /**
     * 有待修改
     * @return
     */
    @Override
    public String addexcelQuan(String fileName, MultipartFile file) {
        return null;
    }

    @Override
    public void deleteQuans(Integer[] scoreId) {
applicationAndReviewDao.deleteQuans(scoreId);
    }

    @Override
    public void deleteQuan(Integer quanId) {
applicationAndReviewDao.deleteQuan(quanId);
    }

    @Override
    public void updateScholarship(Scholarship scholarship) {
         applicationAndReviewDao.updateScholarship(scholarship);
    }

    @Override
    public void updatePoor(Poor poor) {
         applicationAndReviewDao.updatePoor(poor);
    }

    @Override
    public List<Poor> teacherPoor(Integer applicatId) {
        return applicationAndReviewDao.teacherPoor(applicatId);
    }

    @Override
    public List<Scholarship> teacherScholarship(Integer applicatId) {
        return applicationAndReviewDao.teacherScholarship(applicatId);
    }

    @Override
    public List<ApplicationClass> teacherApplicationClass(Integer applicatId) {
        return applicationAndReviewDao.teacherApplicationClass(applicatId);
    }

    @Override
    public List<ApplicationDorm> teacherApplicationDorm3(Integer applicatId) {
        return applicationAndReviewDao.teacherApplicationDorm3(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherOneApplicationLeave(Integer applicatId) {
        return applicationAndReviewDao.teacherOneApplicationLeave(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherTwoApplicationLeave(Integer applicatId) {
        return applicationAndReviewDao.teacherTwoApplicationLeave(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherThreeApplicationDorm(Integer applicatId) {
        return applicationAndReviewDao.teacherThreeApplicationDorm(applicatId);
    }

    @Override
    public List<Poor> teacherPoor6(Integer applicatId) {
        return applicationAndReviewDao.teacherPoor6(applicatId);
    }

    @Override
    public List<Scholarship> teacherScholarship6(Integer applicatId) {
        return applicationAndReviewDao.teacherScholarship6(applicatId);
    }

    @Override
    public List<ApplicationClass> teacherApplicationClass6(Integer applicatId) {
        return applicationAndReviewDao.teacherApplicationClass6(applicatId);
    }

    @Override
    public List<ApplicationDorm> teacherApplicationDorm6(Integer applicatId) {
        return applicationAndReviewDao.teacherApplicationDorm6(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherOneApplicationLeave6(Integer applicatId) {
        return applicationAndReviewDao.teacherOneApplicationLeave6(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherTwoApplicationLeave6(Integer applicatId) {
        return applicationAndReviewDao.teacherTwoApplicationLeave6(applicatId);
    }

    @Override
    public List<ApplicationLeave> teacherThreeApplicationDorm6(Integer applicatId) {
        return applicationAndReviewDao.teacherThreeApplicationDorm6(applicatId);
    }

    @Override
    public void updateOneApplicationLeave(ApplicationLeave applicationLeave) {
         applicationAndReviewDao.updateOneApplicationLeave(applicationLeave);
    }

    @Override
    public void updateTwoApplicationLeave(ApplicationLeave applicationLeave) {
        applicationAndReviewDao.updateTwoApplicationLeave(applicationLeave);
    }

    @Override
    public void updateThreeApplicationLeave(ApplicationLeave applicationLeave) {
         applicationAndReviewDao.updateThreeApplicationLeave(applicationLeave);
    }

    @Override
    public void updateApplicatDorm(ApplicationDorm applicationDorm) {
        if (applicationDorm.getState().equals("1")) {
            applicationAndReviewDao.updateApplicatDorm(applicationDorm);
            ApplicationDorm applicationClass1 = applicationAndReviewDao.findapplicationClassByad(applicationDorm.getLaId());
//            System.out.println(applicationClass1.getStuId());
            Student student =  applicationAndReviewDao.findStudentBystuId(applicationClass1.getStuId());
            student.setDormId(applicationClass1.getNowDormId());
            applicationAndReviewDao.updateStudent6(student);
        }
         applicationAndReviewDao.updateApplicatDorm(applicationDorm);
    }

    @Override
    public void updateApplicationClass(ApplicationClass applicationClass) {
        if (applicationClass.getState().equals("1")) {
            applicationAndReviewDao.updateApplicationClass(applicationClass);
            ApplicationClass applicationClass1 = applicationAndReviewDao.findClassApplicationBycaId(applicationClass.getCaId());
//            System.out.println(applicationClass1.getStuId());
            Student student =  applicationAndReviewDao.findStudentBystuId(applicationClass1.getStuId());
            student.setClassId(applicationClass1.getNowClassId());
//            System.out.println(student);
            applicationAndReviewDao.updateStudent6(student);
        }
        applicationAndReviewDao.updateApplicationClass(applicationClass);
    }


}
