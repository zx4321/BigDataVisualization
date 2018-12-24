package com.lihaogn.dao;

import com.lihaogn.domain.VideoAccessTopN;
import com.lihaogn.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoAccessTopNDAO {

    static Map<String, String> courses = new HashMap<String, String>();

    static {
        courses.put("2402", "Mysql");
        courses.put("1309", "php");
        courses.put("3078", "Java 网络通信");
        courses.put("2801", "Mysql 优化");
        courses.put("1336", "scala");
        courses.put("3369", "Java 基础");

    }

    /**
     * 根据课程编号查询课程名称
     */
    public String getCourseName(String id) {
        return courses.get(id);
    }


    /**
     * 根据day查询当天的最受欢迎的topN课程
     */
    public List<VideoAccessTopN> query(String day) {
        List<VideoAccessTopN> list = new ArrayList<VideoAccessTopN>();

        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            connection = MySQLUtils.getConnection();
            String sql = "select class_id,times from day_vedio_access_topn_stat where day=? order by times desc limit 5";
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, day);

            rs = psmt.executeQuery();

            VideoAccessTopN domain = null;

            while (rs.next()) {
                domain = new VideoAccessTopN();

                domain.setName(getCourseName(rs.getLong("class_id") + ""));
                domain.setValue(rs.getLong("times"));

                list.add(domain);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySQLUtils.release(connection, psmt, rs);
        }
        return list;
    }

    public static void main(String[] args) {
        VideoAccessTopNDAO dao = new VideoAccessTopNDAO();
        List<VideoAccessTopN> list = dao.query("20161110");
        for (VideoAccessTopN result : list) {
            System.out.println(result.getName() + "," + result.getValue());
        }
    }
}
