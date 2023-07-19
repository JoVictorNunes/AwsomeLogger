package com.ufes.logger.log;

import com.opencsv.CSVWriter;
import com.ufes.logger.model.LogRecord;
import java.io.FileWriter;
import java.io.IOException;

public class CsvLogAdapter extends LogAdapter {
    public CsvLogAdapter(String filename) throws RuntimeException {
        super(filename + ".csv");
    }

    @Override
    public void log(LogRecord record) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(file, true));

        addHeader(writer);

        writer.writeNext(
                new String[] {
                        record.getOperation(),
                        record.getName(),
                        record.getData(),
                        record.getTime(),
                        record.getUser()
                }
        );

        writer.close();
    }

    private void addHeader(CSVWriter writer) {
        if (file.length() == 0) {
            writer.writeNext(
                    new String[] { "Operação", "Nome", "Data", "Hora", "Usuário" },
                    false
            );
        }
    }
}
