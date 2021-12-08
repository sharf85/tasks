package de.telran;

public class Main {

    public static void main(String[] args) {
        String str = (String) getItself("Hello");
        String str3 = getItselfGenerified("Hello");

        Integer number = (Integer) getItself(1);
        Integer number2 = getItselfGenerified(1);

        String str2 = (String) getItself(1);

        GenerifiedClass<Integer> integerGenerifiedClass = new GenerifiedClass<>();

        int a = integerGenerifiedClass.getItself(1);
    }

    static Object getItself(Object o) {
        return o;
    }

    static <T> T getItselfGenerified(T o) {
        return o;
    }
}

class GenerifiedClass<T> {
    public T getItself(T o) {
        return o;
    }
}

class CustomInteger {
    private final int value;

    public CustomInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CustomInteger valueOf(int value) {
        return new CustomInteger(value);
    }
}
