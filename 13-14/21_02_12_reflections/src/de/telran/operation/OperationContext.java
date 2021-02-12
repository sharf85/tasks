package de.telran.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    {
        IStringOperation upperCase = new UpperCaseSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);
    }

    public OperationContext() {
    }

    public OperationContext(List<String> operationPaths) {
        // TODO compose 'operationByName' by the paths to the necessary operations
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
