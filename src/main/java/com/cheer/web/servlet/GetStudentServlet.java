package com.cheer.web.servlet;

import com.cheer.model.Student;
import com.cheer.service.StudentService;
import com.cheer.service.impl.StudentServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetStudentServlet", urlPatterns = "/servlet/GetStudentServlet")
public class GetStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter writer = response.getWriter();
        HttpSession session =request.getSession();
        String num = (String)(session.getAttribute("studentNumber"));

        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.find(num);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        Gson gson=new Gson();
        String data=gson.toJson(studentList);
        writer.println(data);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
