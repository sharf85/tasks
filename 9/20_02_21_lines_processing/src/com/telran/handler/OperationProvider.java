package com.telran.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationProvider {
    private Map<String, IOperation> operationByName;

    public OperationProvider(Map<String, IOperation> operationByName) {
        this.operationByName = operationByName;
    }

    public OperationProvider() {
    }

    public IOperation getByName(String name) {
        return operationByName.get(name);
    }

    public void init(List<String> operationPath) {
        operationByName = new HashMap<>();
        for (String op : operationPath) {
            try {
                IOperation operation = (IOperation) Class.forName(op).getConstructor().newInstance();
                operationByName.put(operation.getName(), operation);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new OperationInitException(e);
            }
        }
    }
}
