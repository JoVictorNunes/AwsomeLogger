package com.ufes.logger.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRecord {
    private String operation;
    private String name;
    private String user;
    private String data;
    private String time;

    public LogRecord(String operation, String name, String user) {
        this.operation = operation;
        this.name = name;
        this.user = user;
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        this.data = time.format(dataFormatter);
        this.time = time.format(timeFormatter);
    }
    public LogRecord() {}

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getData() {
        return data;
    }

    public String getTime() {
        return time;
    }
}
