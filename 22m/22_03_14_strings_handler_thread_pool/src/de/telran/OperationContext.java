package de.telran;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads and provides all operations by their names
 */
public class OperationContext {

    // stores operations by their names
    Map<String, IStringOperation> operationsSource = new HashMap<>();

    /**
     * The method creates instances for all the operations by their names and places them into operationsSource
     *
     * @param operationPaths the paths to the operations ('de.telran.operation.UpperCaseOperation')
     */
    public void loadOperations(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (String path : operationPaths) {
            IStringOperation operation = (IStringOperation) Class.forName(path).getConstructor().newInstance();
            operationsSource.put(operation.getName(), operation);
        }
    }

    public IStringOperation getOperation(String name) {
        return operationsSource.get(name);
    }
}
