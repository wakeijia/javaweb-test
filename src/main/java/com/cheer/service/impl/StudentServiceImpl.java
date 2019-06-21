package com.cheer.service.impl;

import com.cheer.dao.StudentMapper;
import com.cheer.model.Student;
import com.cheer.service.StudentService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean checkLogin(String studentNumber, String password) {
        SqlSession session = MybatisUtils.getSqlSession();
        Student student = session.getMapper(StudentMapper.class).find(studentNumber);
        MybatisUtils.closeSqlSession(session);
        if (studentNumber==null){
            return false;
        }
        if (password.equals(student.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public Student find(String studentNumber) {
        SqlSession session = MybatisUtils.getSqlSession();
        Student student = session.getMapper(StudentMapper.class).find(studentNumber);
        MybatisUtils.closeSqlSession(session);
        return student;
    }

    @Override
    public int upData(Student student) {
        SqlSession session = MybatisUtils.getSqlSession();
        int i = session.getMapper(StudentMapper.class).update(student);
        MybatisUtils.closeSqlSession(session);

        if(i>0){
            System.out.println("修改成功");
            return i;
        }else{
            System.out.println("修改失败");
            return i;
        }
    }

}
