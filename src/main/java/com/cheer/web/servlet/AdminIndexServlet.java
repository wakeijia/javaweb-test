package com.cheer.web.servlet;

import com.cheer.importer.ImportImpl;
import com.cheer.model.Ques;
import com.cheer.service.QuesService;
import com.cheer.service.impl.QuesServiceImpl;
import com.cheer.util.ReadExcel;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminIndexServlet", urlPatterns = "/servlet/AdminIndexServlet")
public class AdminIndexServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(AdminIndexServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        /*String file = "C:\\Users\\wakei\\Desktop\\题目.xlsx";

        ImportImpl importImpl = new ImportImpl();
        try {
            importImpl.importData(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("导入失败");
        }*/
        PrintWriter writer = response.getWriter();
        QuesService quesService = new QuesServiceImpl();
        List<Ques> quesList = quesService.getList();
        LOGGER.trace(quesList);
        Gson gson = new Gson();
        String data = gson.toJson(quesList);

        writer.println(data);
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
