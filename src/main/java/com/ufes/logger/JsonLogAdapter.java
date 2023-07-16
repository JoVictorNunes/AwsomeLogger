package com.ufes.logger;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JsonLogAdapter implements LogAdapter {
    private String filepath;

    public JsonLogAdapter() {
        try {
            Dotenv dotenv = Dotenv.load();
            filepath = dotenv.get("JSON_LOG_FILE");
        } catch (DotenvException e) {
            System.err.println(e.getMessage());
        } finally {
            if (filepath == null) {
                filepath = "output.log";
            }
        }
    }

    @Override
    public void log(String operation, String name, String user) throws IOException {
        FileWriter writer = new FileWriter(filepath, true);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String msg = String.format(
                "%s:%s,%s,%s,%s",
                operation,
                name,
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                time.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                user
        );
        writer.write(msg);
        writer.flush();
        writer.close();
    }
}
