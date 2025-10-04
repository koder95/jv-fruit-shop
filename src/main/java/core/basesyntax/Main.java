package core.basesyntax;

import core.basesyntax.impl.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Path LOAD_PATH = Path.of("reportToRead.csv");
    public static final Path SAVE_PATH = Path.of("finalReport.csv");

    public static void main(String[] args) {
        // read data
        DefaultFruitTypeFactory fruitTypeFactory = new DefaultFruitTypeFactory();
        TransactionRequestDeserializer deserializer = new CSVTransactionRequestDeserializer(fruitTypeFactory);
        List<TransactionRequest> transactionRequests = deserializer.loadFrom(LOAD_PATH);
        // process data
        Map<TransactionType, TransactionHandler> handlers = new HashMap<>();
        handlers.put(TransactionType.BALANCE, BalanceTransactionHandler.instance());
        handlers.put(TransactionType.SUPPLY, SupplyTransactionHandler.instance());
        handlers.put(TransactionType.PURCHASE, PurchaseTransactionHandler.instance());
        handlers.put(TransactionType.RETURN, ReturnTransactionHandler.instance());
        TransactionService service = new MapTransactionService(handlers);
        Database database = new MapDatabase(service);
        database.handleAll(transactionRequests);
        // generate raport
        Reporter reporter = new ReporterImpl();
        Report report = reporter.reportWith(database);
        // write raport
        ReportSerializer serializer = new CSVReportSerializer();
        serializer.save(report, SAVE_PATH);
    }
}
