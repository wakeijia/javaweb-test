package com.cheer.model;

import java.io.Serializable;

public class Student implements Serializable {

    private String studentNumber;
    private String password;
    private int rights;
    private int errors;
    private int ignores;
    private int scores;

    public Student(){
    }

    public Student(String studentNumber,String password,int rights,int errors,int ignores,int scores){
        this.studentNumber = studentNumber;
        this.password = password;
        this.errors = errors;
        this.rights = rights;
        this.ignores =ignores;
        this.scores = scores;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getIgnores() {
        return ignores;
    }

    public void setIgnores(int ignores) {
        this.ignores = ignores;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }



    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", password='" + password + '\'' +
                ", rights=" + rights +
                ", errors=" + errors +
                ", ignores=" + ignores +
                ", scores=" + scores +
                '}';
    }
}
