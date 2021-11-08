package de.telran.human;

public class Human {

    private static long humanNumber = 0;

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;
        humanNumber++;
    }

    public static long getHumanNumber() {
        return humanNumber;
    }

    private int age;//field
    private String name;
    private String surname;
    private boolean isAlive = true;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void die() {
        humanNumber--;
        isAlive = false;
    }

    public void introduce() {
        if (isAlive)
            System.out.println("My name is " + name + " " + surname + ". I am " + age + " years old.");
        else
            System.out.println("R.I.P");
    }
}

