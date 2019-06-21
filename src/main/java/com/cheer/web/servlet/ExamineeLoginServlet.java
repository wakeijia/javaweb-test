package com.cheer.web.servlet;

import com.cheer.model.Ques;
import com.cheer.model.Student;
import com.cheer.service.StudentService;
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

@WebServlet(name = "ExamineeLoginServlet", urlPatterns = "/servlet/ExamineeLoginServlet")
public class ExamineeLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ExamineeLoginServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNumber");
        String password = request.getParameter("password");

        StudentService studentService = new StudentServiceImpl();

        if (studentService.checkLogin(studentNumber,password)){
            LOGGER.trace("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("studentNumber",studentNumber);

            // (1)使用相对路径
            //response.sendRedirect("../ExamineeIndex.html");

            // (2)使用绝对路径跳转
            String contextPath = request.getContextPath();

            response.sendRedirect(contextPath + "/ExamineeIndex.html");
        }else {
            System.out.println("登录失败");
            response.sendRedirect("../ExamineeLogin.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
