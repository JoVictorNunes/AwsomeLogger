package com.ufes.logger.log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ufes.logger.model.LogRecord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonLogAdapter extends LogAdapter {
    public JsonLogAdapter(String filename) {
        super(filename + ".json");
    }

    @Override
    public void log(LogRecord record) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<LogRecord> records = readPreviousRecords(mapper);
        records.add(record);
        writer.writeValue(file, records);
    }

    private List<LogRecord> readPreviousRecords(ObjectMapper mapper) {
        List<LogRecord> records;

        try {
            records = mapper.readValue(file, new TypeReference<List<LogRecord>>() {});
        } catch (Exception e) {
            System.err.println(e.getMessage());
            records = new ArrayList<>();
        }

        return records;
    }
}
