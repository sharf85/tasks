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

    /**
     * This issuer decides whether to provide a loan to the customer by the following rules:
     * 1. If the customer earns less than 20000 gold or he is younger than 18 y.o. then no loan
     * may be provided.
     * 2. if this issuer is lazy, then matching these two conditions would be enough for him to
     * provide a loan (meaning, the customer earns >= 20000 gold and he is 18 or older)
     * 3. Else if this issuer is kind, they provide a load if the customer is younger than 70 y.o.
     * 4. Else this issuer provides the loan in case if the customer is younger than 50 y.o.
     *
     * @param loanConsumer the customer whom to provide a loan
     * @return whether the loan is provided
     */
    public boolean toIssue(LoanConsumer loanConsumer) {
//        if (loanConsumer.getAge() >= 18 && loanConsumer.getAnnualIncome() >= 20000) {
//            if (this.isLazy)
//                return true;
//
//            if (loanConsumer.getAge() < 50)
//                return true;
//
//            if (this.isKind && loanConsumer.getAge() < 70)
//                return true;
//        }
//
//        return false;
        
        if (loanConsumer.getAge() < 18 || loanConsumer.getAnnualIncome() < 20000)
            return false;

        if (this.isLazy)
            return true;

        if (loanConsumer.getAge() < 50)
            return true;

        if (this.isKind && loanConsumer.getAge() < 70)
            return true;

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
