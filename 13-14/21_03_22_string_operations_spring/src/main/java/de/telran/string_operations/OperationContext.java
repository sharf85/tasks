package de.telran.string_operations;

import de.telran.string_operations.service.operation.IStringOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

// The object of the class returns a certain operation by its name
// TODO create a bean and place it to the ApplicationContext
public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    public OperationContext(List<IStringOperation> operations) {
        operationByName = operations.stream()
                .collect(toMap(IStringOperation::getName, operation -> operation));

//        operationByName = new HashMap<>();
//        for (IStringOperation operation : operations) {
//            operationByName.put(operation.getName(), operation);
//        }
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
