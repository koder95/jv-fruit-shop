package core.basesyntax.service.impl;

import core.basesyntax.db.Database;
import core.basesyntax.model.FruitType;
import core.basesyntax.service.TransactionHandler;
import java.math.BigInteger;

public class ReturnTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new ReturnTransactionHandler();

    private ReturnTransactionHandler() {
    }

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger quantity) {
        database.add(fruitType, quantity);
    }
}
