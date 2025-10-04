package core.basesyntax.impl;

import core.basesyntax.Database;
import core.basesyntax.FruitType;
import core.basesyntax.TransactionService;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class MapDatabase implements Database {
    private final Map<FruitType, BigInteger> fruitAmountMap;
    private final TransactionService service;

    public MapDatabase(Map<FruitType, BigInteger> fruitAmountMap, TransactionService service) {
        this.fruitAmountMap = fruitAmountMap;
        this.service = service;
    }

    public MapDatabase(TransactionService service) {
        this(new ConcurrentHashMap<>(), service);
    }

    @Override
    public TransactionService getTransactionService() {
        return service;
    }

    @Override
    public void set(FruitType fruitType, BigInteger amount) {
        fruitAmountMap.put(fruitType, amount);
    }

    @Override
    public void add(FruitType fruitType, BigInteger amount) {
        BigInteger oldOrZero = fruitAmountMap.getOrDefault(fruitType, BigInteger.ZERO);
        set(fruitType, oldOrZero.add(amount));
    }

    @Override
    public void remove(FruitType fruitType, BigInteger amount) {
        BigInteger oldOrZero = fruitAmountMap.getOrDefault(fruitType, BigInteger.ZERO);
        set(fruitType, oldOrZero.subtract(amount));
    }

    @Override
    public void consume(BiConsumer<FruitType, BigInteger> consumer) {
        fruitAmountMap.forEach(consumer);
    }
}
