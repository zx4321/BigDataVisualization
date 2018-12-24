package com.lihaogn.web;

import com.lihaogn.utils.ReadFile1;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class pickUpDateTimeDay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=utf-8");
        String path = this.getServletContext().getRealPath("data/pickUpDateTimeDay.txt");
        JSONArray jsonArray = new ReadFile1().readfromfile(path);
        PrintWriter writer = resp.getWriter();
        writer.println(jsonArray);
        writer.flush();
        writer.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}