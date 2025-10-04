package core.basesyntax;

public interface FruitTypeFactory {
    default FruitType create(String name) {
        return new FruitType(name);
    }
}
