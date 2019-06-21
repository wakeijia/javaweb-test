package com.cheer.service;

import com.cheer.model.Student;

public interface StudentService {

    boolean checkLogin(String studentNumber,String password);

    Student find(String studentNumber);

    int upData(Student student);

}
