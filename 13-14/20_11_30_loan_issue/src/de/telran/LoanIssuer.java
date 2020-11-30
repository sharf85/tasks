package de.telran;

public class LoanIssuer {

    private String name;
    private boolean isKind;
    private boolean isLazy;

    public LoanIssuer(String name, boolean isKind, boolean isLazy) {
        this.name = name;
        this.isKind = isKind;
        this.isLazy = isLazy;
    }

    //TODO implement
    public boolean toIssue(LoanConsumer loanConsumer) {
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isKind() {
        return isKind;
    }

    public boolean isLazy() {
        return isLazy;
    }

}
