package core.basesyntax;

import java.nio.file.Path;
import java.util.List;

public interface TransactionRequestDeserializer {
    List<TransactionRequest> loadFrom(Path path);
}
