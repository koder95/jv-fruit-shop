package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;

import java.math.BigInteger;

public class PurchaseTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new PurchaseTransactionHandler();

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    private PurchaseTransactionHandler() {}

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger amount) {
        database.remove(fruitType, amount);
    }
}
