package org.example.FileModule;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MathFileWorker {
    private static String filePathData = "Files\\data.json";
    private static String filePathResult = "Files\\result.json";


    public static String getFilePathData() {
        return filePathData;
    }

    public static String getFilePathResult() {
        return filePathResult;
    }

    public static String readDataFile() throws IOException {
        String json = "";
        String temp;
        BufferedReader reader = new BufferedReader(new FileReader(filePathData));
        while((temp = reader.readLine()) != null){
            json += temp;
        }

        reader.close();
        return json;
    }

    public static String readResultFile() throws IOException {
        String json = "";
        String temp;
        BufferedReader reader = new BufferedReader(new FileReader(filePathResult));

        while((temp = reader.readLine()) != null){
            json += temp;
        }

        reader.close();
        return json;
    }
}
