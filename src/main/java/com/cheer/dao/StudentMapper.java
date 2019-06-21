package com.cheer.dao;

import com.cheer.model.Student;


public interface StudentMapper {

    Student find(String studentNumber);

    int update(Student student);

}
