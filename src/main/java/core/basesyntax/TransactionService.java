package core.basesyntax;

public interface TransactionService {
    TransactionHandler selectHandler(TransactionType transactionType);
}
