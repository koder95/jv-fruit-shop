package core.basesyntax;

import java.nio.file.Path;

public interface ReportSerializer {
    void save(Report report, Path path);
}
