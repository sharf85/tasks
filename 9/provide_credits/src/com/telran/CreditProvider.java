package com.telran;

public class CreditProvider {

    String name;
    String surname;
    boolean isLazy;
    boolean isKind;

    public CreditProvider(String name, String surname, boolean isLazy, boolean isKind) {
        this.name = name;
        this.surname = surname;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    /**
     * hjghjjhhjg
     *
     * @param creditUser
     * @return
     */
    boolean toProvide(CreditUser creditUser) {
        if (this.isLazy) {
            if (creditUser.annualSalary > 20000) {
                return true;
            } else {
                return false;
            }
        }

        if (!this.isKind) {
            if (creditUser.annualSalary > 20000 && creditUser.age < 50)
                return true;
            else
                return false;
        }

        if (creditUser.annualSalary > 20000 && creditUser.age < 70)
            return true;

        return false;
    }
}
