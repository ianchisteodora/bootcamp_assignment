package org.example.controller;

import org.example.model.ConfigurationManager;
import org.example.model.User;

public class LoggingController {

    private LoggingStrategy loggingStrategy;

    public LoggingController(LoggingStrategy loggingStrategy){
        this.loggingStrategy = loggingStrategy;
    }

    public void setLoggingStrategy(LoggingStrategy loggingStrategy){
        this.loggingStrategy = loggingStrategy;
    }





}
