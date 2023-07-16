package com.ufes.logger;

import java.io.IOException;

public interface LogAdapter {
    void log(String operation, String name, String user) throws IOException;
}
