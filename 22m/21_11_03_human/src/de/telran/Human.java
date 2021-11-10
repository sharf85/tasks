package de.telran;

public class Human {

    private static int humanNumber = 0;
    private static double averageAge = 0;

    private String name;
    private String surname;
    private int age;
    private String email;
    private boolean isAlive = true;

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;

        averageAge = (averageAge * humanNumber + age) / (++humanNumber);
    }

    public Human(String specifiedName, String specifiedSurname, int specifiedAge, String email) {
        this(specifiedName, specifiedSurname, specifiedAge);
        this.email = email;
    }

    public static int getHumanNumber() {
        return humanNumber;
    }

    public static int getAverageAge() {
        return (int) averageAge;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void die() {
        if (isAlive) {
            isAlive = false;
            averageAge = (averageAge * humanNumber - age) / (--humanNumber);
        }
    }

    public void introduce() {
        if (!isAlive)
            System.out.println("R.I.P.");
        else if (age < 50)
            System.out.println("Hi, my name is " + name + " " + surname + ". I am " + age + " years old.");
        else
            System.out.println("Hello, my name is " + name + " " + surname + ". I am " + age + " years old.");
    }
}

