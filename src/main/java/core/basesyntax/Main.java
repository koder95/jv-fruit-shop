package core.basesyntax;

import core.basesyntax.impl.BalanceTransactionHandler;
import core.basesyntax.impl.CsvReportSerializer;
import core.basesyntax.impl.CsvTransactionRequestDeserializer;
import core.basesyntax.impl.DefaultFruitTypeFactory;
import core.basesyntax.impl.MapDatabase;
import core.basesyntax.impl.MapTransactionService;
import core.basesyntax.impl.PurchaseTransactionHandler;
import core.basesyntax.impl.ReporterImpl;
import core.basesyntax.impl.ReturnTransactionHandler;
import core.basesyntax.impl.SupplyTransactionHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Path LOAD_PATH = Path.of("reportToRead.csv");
    public static final Path SAVE_PATH = Path.of("finalReport.csv");

    public static void main(String[] args) {
        // read data
        List<TransactionRequest> transactionRequests = loadTransactionRequestList();
        // process data
        Database database = createDatabase();
        database.handleAll(transactionRequests);
        // generate raport
        Report report = createReport(database);
        // write raport
        saveReport(report);
    }

    private static Report createReport(Database database) {
        Reporter reporter = new ReporterImpl();
        return reporter.reportWith(database);
    }

    private static MapDatabase createDatabase() {
        Map<TransactionType, TransactionHandler> handlers = createTransactionTypeMap();
        TransactionService service = createTransactionService(handlers);
        return new MapDatabase(service);
    }

    private static TransactionService createTransactionService(
            Map<TransactionType, TransactionHandler> handlers) {
        return new MapTransactionService(handlers);
    }

    private static CsvTransactionRequestDeserializer createTransactionRequestDeserializer() {
        return new CsvTransactionRequestDeserializer(new DefaultFruitTypeFactory());
    }

    private static Map<TransactionType, TransactionHandler> createTransactionTypeMap() {
        HashMap<TransactionType, TransactionHandler> map = new HashMap<>();
        map.put(TransactionType.BALANCE, BalanceTransactionHandler.instance());
        map.put(TransactionType.SUPPLY, SupplyTransactionHandler.instance());
        map.put(TransactionType.PURCHASE, PurchaseTransactionHandler.instance());
        map.put(TransactionType.RETURN, ReturnTransactionHandler.instance());
        return Map.copyOf(map);
    }

    private static List<TransactionRequest> loadTransactionRequestList() {
        TransactionRequestDeserializer deserializer = createTransactionRequestDeserializer();
        return deserializer.loadFrom(LOAD_PATH);
    }

    private static void saveReport(Report report) {
        ReportSerializer serializer = new CsvReportSerializer();
        serializer.save(report, SAVE_PATH);
    }
}
