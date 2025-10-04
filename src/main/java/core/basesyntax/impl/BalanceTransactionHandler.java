package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;

import java.math.BigInteger;

public class BalanceTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new BalanceTransactionHandler();

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    private BalanceTransactionHandler() {}

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger amount) {
        database.set(fruitType, amount);
    }
}
