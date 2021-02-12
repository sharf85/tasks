package de.telran;

import de.telran.operation.IStringOperation;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // how to create an instance of a class by its name

        String operationPath = "de.telran.operation.UpperCaseSO";
        IStringOperation operation = (IStringOperation) Class
                .forName(operationPath)
                .getConstructor(String.class, Integer.class)
                .newInstance("vasy", 10);

        IStringOperation operation1 = (IStringOperation) Class
                .forName(operationPath)
                .getConstructor()
                .newInstance();

        System.out.println(operation);
        System.out.println(operation1);
    }
}

