package com.lihaogn.web;

import com.lihaogn.domain.GeoCoordMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BigDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");
        System.out.print(day);

        GeoCoordMap geoCoordMap;

        JSONObject jsonobj = new JSONObject();
        int i = 0;
        while (i < 100) {
            geoCoordMap = new GeoCoordMap((i + ""), Arrays.asList(103+i/10.0, 36+i/10.0));
            jsonobj.put(geoCoordMap.getName(), geoCoordMap.getList());
            i++;
        }

        resp.setContentType("text/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.println(jsonobj);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
