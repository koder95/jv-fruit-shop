package core.basesyntax.impl;

import java.math.BigInteger;
import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;

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
