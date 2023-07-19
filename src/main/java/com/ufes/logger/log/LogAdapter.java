package com.ufes.logger.log;

import com.ufes.logger.model.LogRecord;

import java.io.File;
import java.io.IOException;

public abstract class LogAdapter {
    protected File file;

    public LogAdapter(String filename) {
        file = new File(filename);
    }

    public abstract void log(LogRecord record) throws IOException;
}
