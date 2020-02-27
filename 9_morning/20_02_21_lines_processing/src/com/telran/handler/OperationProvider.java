package com.telran.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationProvider {

    private Map<String, IOperation> operationByName;
    private List<String> operationPaths;

    public OperationProvider(List<String> operationPaths) {
        this.operationPaths = operationPaths;
        operationByName = new HashMap<>();
    }

//    public OperationProvider(Map<String, IOperation> operationByName) {
//        this.operationByName = operationByName;
//    }

    public void load() {
        for (String path : operationPaths) {
            try {
                IOperation operation = (IOperation) Class.forName(path).getConstructor().newInstance();
                operationByName.put(operation.getName(), operation);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new WrongOperationPathException(e);
            }
        }
    }

    public IOperation getByName(String name) {
        return operationByName.get(name);
    }

}
