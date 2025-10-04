package core.basesyntax.impl;

import core.basesyntax.FruitType;
import core.basesyntax.Report;
import core.basesyntax.ReportSerializer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReportSerializer implements ReportSerializer {
    @Override
    public void save(Report report, Path path) {
        List<String> csvRows = createCSVRows(report);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String line : csvRows) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> createCSVRows(Report report) {
        List<String> lines = new ArrayList<>();
        lines.add("fruit,quantity");
        report.consume((fruitType, amount) -> lines.add(createCSVRow(fruitType, amount)));
        return lines;
    }

    private String createCSVRow(FruitType fruitType, BigInteger amount) {
        return String.join(",", fruitType.name(), amount.toString());
    }
}
