package com.cheer.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/servlet/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if ("admin".equals(username)&&"admin".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);

            // 使用绝对路径跳转
            String contextPath = request.getContextPath();

            response.sendRedirect(contextPath + "/AdminIndex.html");
        }else {
            System.out.println("登录失败");
            response.sendRedirect("../AdminLogin.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
