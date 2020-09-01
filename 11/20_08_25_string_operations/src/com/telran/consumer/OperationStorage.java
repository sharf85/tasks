package com.telran.consumer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * After instantiating an object, the client must invoke the init() method, which completes
 * the instantiation of the object.
 */
public class OperationStorage {

    Map<String, IStringOperation> operationByName;

    /**
     * The method fills operationByName object
     *
     * @param paths of the operation to initialize
     */
    public void init(List<String> paths) throws ClassNotFoundException, OperationStorageInstantiationException {
        operationByName = new HashMap<>();

        try {
            for (String path : paths) {
                IStringOperation operation = (IStringOperation) Class.forName(path).getConstructor().newInstance();
                operationByName.put(operation.getName(), operation);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new OperationStorageInstantiationException(e.getMessage(), e);
        }
    }

    public IStringOperation getByName(String name) {
        return operationByName.get(name);
    }

}
