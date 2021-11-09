package de.telran;

public class Human {

    private static int humanNumber = 0;
    private static double averageAge = 0;

    private String name;
    private String surname;
    private int age;
    private String email;

    //TODO introduce here the new variable called isAlive which is true if the person is alive and false otherwise

    public Human(String specifiedName, String specifiedSurname, int specifiedAge) {
        name = specifiedName;
        surname = specifiedSurname;
        age = specifiedAge;

        averageAge = (averageAge * humanNumber + age) / (++humanNumber);

//
////-------------------
//        humanNumber++;
//
//        int temp = humanNumber;
//        humanNumber = humanNumber + 1;
//
//        ++humanNumber;
//
//        humanNumber = humanNumber + 1;
//        int temp1 = humanNumber;
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

    public void die() {
        // TODO implement here the functionality of a dying human
        // 1. The number of humans must decrease
        // 2. The average age of humans must be recalculated
    }

    public void introduce() {
        //TODO depending on whether the person is alive, they can or not introduce themselves. Implement it here.
        // If the person is not alive, the method should print "R.I.P."
        if (age < 50)
            System.out.println("Hi, my name is " + name + " " + surname + ". I am " + age + " years old.");
        else
            System.out.println("Hello, my name is " + name + " " + surname + ". I am " + age + " years old.");
    }
}

