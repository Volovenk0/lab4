package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.example.FileModule.MathFileWorker;
import org.example.MathModule.MathIntegral;
import org.example.MathModule.ResultIntegral;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter A: ");
        int numA = sc.nextInt();
        System.out.print("Enter B: ");
        int numB = sc.nextInt();


        ObjectMapper objectMapper = new ObjectMapper();
        MathIntegral mathIntegral = new MathIntegral(numA, numB);
        objectMapper.writeValue(new File(MathFileWorker.getFilePathData()), mathIntegral);

        String json = MathFileWorker.readDataFile();

        System.out.println("Data from file: ");
        System.out.println(json);
        mathIntegral = objectMapper.readValue(json, MathIntegral.class);

        ResultIntegral result = mathIntegral.getIntegral(x -> {return Math.pow(x, 2);});

        System.out.println("Result: " + result.getResult());
        objectMapper.writeValue(new File(MathFileWorker.getFilePathResult()), result);

        System.out.println("Json result: " + MathFileWorker.readResultFile());

    }
}