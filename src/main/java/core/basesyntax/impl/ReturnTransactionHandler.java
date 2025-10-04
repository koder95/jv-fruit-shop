package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;

import java.math.BigInteger;

public class ReturnTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new ReturnTransactionHandler();

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    private ReturnTransactionHandler() {}

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger amount) {
        database.add(fruitType, amount);
    }
}
