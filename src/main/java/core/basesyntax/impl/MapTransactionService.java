package core.basesyntax.impl;

import java.util.Map;
import core.basesyntax.TransactionHandler;
import core.basesyntax.TransactionService;
import core.basesyntax.TransactionType;

public class MapTransactionService implements TransactionService {
    private final Map<TransactionType, TransactionHandler> handlers;

    public MapTransactionService(Map<TransactionType, TransactionHandler> handlers) {
        this.handlers = Map.copyOf(handlers);
    }

    public TransactionHandler selectHandler(TransactionType transactionType) {
        return handlers.get(transactionType);
    }
}
