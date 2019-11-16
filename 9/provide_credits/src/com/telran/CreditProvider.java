package com.telran;

public class CreditProvider {

    private static final int SALARY_BORDER = 20000;
    private static final int MIDDLE_AGE = 50;
    private static final int OLD_AGE = 70;

    private String name;
    private String surname;
    private boolean isLazy;
    private boolean isKind;

    public boolean isLazy() {
        return isLazy;
    }

    public boolean isKind() {
        return isKind;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public CreditProvider(String name, String surname, boolean isLazy, boolean isKind) {
        this.name = name;
        this.surname = surname;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    /**
     * The function decides whether this provider will provide a credit to this creditUser
     *
     * @param creditUser
     * @return
     */
    public boolean toProvide(CreditUser creditUser) {
        if (this.isLazy) {
            return creditUser.annualSalary > SALARY_BORDER;
        }

        if (!this.isKind) {
            return creditUser.annualSalary > SALARY_BORDER && creditUser.age < MIDDLE_AGE;
        }

        return creditUser.annualSalary > SALARY_BORDER && creditUser.age < OLD_AGE;
    }

    private class Inner {

    }

}
