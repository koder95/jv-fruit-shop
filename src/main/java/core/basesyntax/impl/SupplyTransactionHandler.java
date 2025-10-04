package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;
import java.math.BigInteger;

public class SupplyTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new SupplyTransactionHandler();

    private SupplyTransactionHandler() {
    }

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger amount) {
        database.add(fruitType, amount);
    }
}
