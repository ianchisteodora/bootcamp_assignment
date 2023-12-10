package org.example.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggingStrategy implements LoggingStrategy{
    private String fileName;
    private PrintWriter writer;

    public FileLoggingStrategy(String fileName){
        this.fileName = fileName;
        try{
            this.writer = new PrintWriter(new FileWriter(fileName, true), true);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void logMessage(String message) {
        String formattedLog = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + " ' " + message + " ' ";

        writer.println(formattedLog);
        System.out.println("File Log: " + formattedLog);

    }

    public void close(){
        if(writer != null){
            writer.close();
        }
    }
}
