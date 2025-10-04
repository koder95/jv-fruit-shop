package core.basesyntax;

public enum TransactionType {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private final String code;

    public String getCode() {
        return code;
    }

    TransactionType(String code) {
        this.code = code;
    }
}
