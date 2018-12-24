package com.lihaogn.utils;

import java.io.*;

public class pickUpUtils {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("src/main/webapp/pickUpData/pickUp1.txt"));
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/webapp/data/pickUp.txt"));
            String line = "";
            int k = 1;
            int fileNum = 1;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                if (k % 1000000 == 0) {
                    fos.close();
                    System.out.println("src/main/webapp/pickUpData/pickUp" + fileNum + ".txt");
                    fileNum++;
                    fos = new FileOutputStream(new File("src/main/webapp/pickUpData/pickUp" + fileNum + ".txt"));
                } else {
                    fos.write((line.split("  ")[0] + "\n").getBytes());
                    fos.write((line.split("  ")[1] + "\n").getBytes());
                }
                k++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
