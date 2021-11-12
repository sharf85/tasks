package de.telran.human;

public class Human {

    private static long humanNumber;
    private static double averageAge;

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;
        averageAge = (averageAge * humanNumber + specifiedAge) / (++humanNumber);
    }

    public static long getHumanNumber() {
        return humanNumber;
    }

    public static int getAverageAge() {
        return (int) averageAge;
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
        if (isAlive) {
            averageAge = (averageAge * humanNumber - age) / (--humanNumber);
            isAlive = false;
        }
    }

    public void introduce() {
        if (isAlive)
            System.out.println("My name is " + name + " " + surname + ". I am " + age + " years old.");
        else
            System.out.println("R.I.P");
    }
}

