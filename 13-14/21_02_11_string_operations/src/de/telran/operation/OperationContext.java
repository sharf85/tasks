package de.telran.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        operationByName = new HashMap<>();
        for (String operationPath : operationPaths) {
            IStringOperation operation = loadOperation(operationPath);
            operationByName.put(operation.getName(), operation);
        }
    }

    IStringOperation loadOperation(String operationPath) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (IStringOperation) Class
                .forName(operationPath)
                .getConstructor()
                .newInstance();
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
