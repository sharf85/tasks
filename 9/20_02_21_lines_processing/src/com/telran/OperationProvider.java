package com.telran;

import java.util.Map;

public class OperationProvider {
    private Map<String, IOperation> operationByName;

    public OperationProvider(Map<String, IOperation> operationByName) {
        this.operationByName = operationByName;
    }

    public IOperation getByName(String name) {
        return operationByName.get(name);
    }
}
