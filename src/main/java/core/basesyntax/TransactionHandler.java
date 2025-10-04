package core.basesyntax;

import java.math.BigInteger;

public interface TransactionHandler {
    void handle(Database database, FruitType fruitType, BigInteger amount);
}
