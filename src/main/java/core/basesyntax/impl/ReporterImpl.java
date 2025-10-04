package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.Report;
import core.basesyntax.Reporter;

public class ReporterImpl implements Reporter {
    @Override
    public Report reportWith(Database database) {
        Report.Builder builder = Report.builder();
        database.consume(builder::set);
        return builder.get();
    }
}
