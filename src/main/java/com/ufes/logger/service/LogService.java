package com.ufes.logger.service;

import com.ufes.logger.log.LogAdapter;
import com.ufes.logger.model.LogRecord;

import java.io.IOException;

public class LogService {
    private LogAdapter logger;

    public LogService(LogAdapter logger) {
        this.logger = logger;
    }

    public void setLogger(LogAdapter logger) {
        this.logger = logger;
    }

    public void log(LogRecord record) throws IOException {
        this.logger.log(record);
    }
}
