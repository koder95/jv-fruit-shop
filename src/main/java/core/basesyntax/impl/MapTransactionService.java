package core.basesyntax.impl;

import core.basesyntax.*;

import java.util.Map;

public class MapTransactionService implements TransactionService {
    private final Map<TransactionType, TransactionHandler> handlers;

    public MapTransactionService(Map<TransactionType, TransactionHandler> handlers) {
        this.handlers = Map.copyOf(handlers);
    }

    public TransactionHandler selectHandler(TransactionType transactionType) {
        return handlers.get(transactionType);
    }
}
