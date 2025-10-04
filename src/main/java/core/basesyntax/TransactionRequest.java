package core.basesyntax;

import java.math.BigInteger;

public record TransactionRequest(TransactionType transactionType, FruitType fruitType, BigInteger amount) {
}
