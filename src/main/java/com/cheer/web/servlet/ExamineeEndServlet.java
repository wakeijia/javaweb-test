package com.cheer.web.servlet;

import com.cheer.model.Student;
import com.cheer.service.QuesService;
import com.cheer.service.StudentService;
import com.cheer.service.impl.QuesServiceImpl;
import com.cheer.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ExamineeEndServlet", urlPatterns = "/servlet/ExamineeEndServlet")
public class ExamineeEndServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ExamineeEndServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session =request.getSession();

        String num = (String)(session.getAttribute("studentNumber"));

        String[] ans = request.getParameterValues("radio");

        LOGGER.trace(ans);

        QuesService quesService = new QuesServiceImpl();

        List<String> stringList = quesService.getAnswer();

        int j = 0;
        int k = 0;
        int n = 20;
        int m = 0;

        for (int i = 0; i <ans.length ; i++) {
            if (ans[i].equals("")){
                m++;
            }else {
                if(ans[i].equals(stringList.get(i).split("：")[1])){
                    j++;
                }else{
                    k++;
                }
            }
        }

        Student student = new Student(num,null, j , k , m , n*j);

        StudentService studentService = new StudentServiceImpl();
        int upData = studentService.upData(student);

        writer.println(upData);
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
