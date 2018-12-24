package com.lihaogn.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile1 {
    public JSONArray readfromfile(String path) {
        JSONArray jsonArray = new JSONArray();
        JSONObject result;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = "1";
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                result = new JSONObject();
                result.put(line.split("  ")[0], line.split("  ")[1]);
                jsonArray.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

}
