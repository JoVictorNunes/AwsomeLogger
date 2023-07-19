package com.ufes.logger.log;

public class LogFactory {
    public static LogAdapter create(int type, String filename) {
        if (type == 0) {
            return new JsonLogAdapter(filename);
        } else if (type == 1) {
            return new CsvLogAdapter(filename);
        }
        throw new RuntimeException("Invalid log type: " + type + ". The following types are available: 1 (JSON), 2 (CSV)");
    }
}
