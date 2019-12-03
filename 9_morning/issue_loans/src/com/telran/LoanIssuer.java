package com.telran;

public class LoanIssuer {

    private String name;
    private boolean isLazy;
    private boolean isKind;

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public boolean toProvide(LoanConsumer consumer) {
        if (consumer.getAnnualSalary() < 20000)
            return false;

        if (this.isLazy)
            return true;

        if (consumer.getAge() <= 50)
            return true;

        if (this.isKind && consumer.getAge() <= 70) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public boolean isKind() {
        return isKind;
    }
}
