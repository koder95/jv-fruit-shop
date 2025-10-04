package core.basesyntax.impl;

import java.math.BigInteger;
import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionHandler;

public class SupplyTransactionHandler implements TransactionHandler {
    private static final TransactionHandler INSTANCE = new SupplyTransactionHandler();

    public static TransactionHandler instance() {
        return INSTANCE;
    }

    private SupplyTransactionHandler() {}

    @Override
    public void handle(Database database, FruitType fruitType, BigInteger amount) {
        database.add(fruitType, amount);
    }
}
