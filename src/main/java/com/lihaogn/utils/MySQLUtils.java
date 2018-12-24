package com.lihaogn.utils;

import net.sf.json.JSONObject;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * MySQL工具类
 */
public class MySQLUtils {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootroot";
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sparkSql_project";

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVERCLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 释放资源
     */
    public static void release(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(getConnection());
//        double x = 132.4776611328125;
//        double y = 12.0000;
//        byte byt[];
//        FileOutputStream fos = new FileOutputStream(new File("src/main/webapp/aaa.bin"));
//        int i = 0;
//        while (i < 100000) {
//            x = x + 0.01;
//            y = y + 0.01;
//            byt = (x + "\n" + y + "\n").getBytes();
//            fos.write(byt);
//            i++;
//        }
//        fos.close();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/tripDistance.txt"));
            String line = null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
                System.out.println(line.split("  ")[0]);
                System.out.println(line.split("  ")[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
