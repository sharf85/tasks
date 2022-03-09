package de.telran;

// Violates the 2nd SOLID principle.
// S - single responsibility - принцип единой ответственности. Метод должен решать одну задачу. Класс должен описывать
// только что-то одно.
// O - open close. Код откыт к расширению, но закрыт к изменению

import de.telran.animal.Cat;
import de.telran.animal.Dog;
import de.telran.animal.Fish;

public class AnimalStore {

    /**
     * The method accepts the type of the wanted animal as a name of the class.
     * @param type the name of the class
     * @return an instance of the class
     */
    public Animal sale(String type) {
        // TODO remake so that the method does not violate the 2nd SOLID principle
        if (type.equals("Cat"))
            return new Cat();
        else if (type.equals("Dog"))
            return new Dog();
        else if (type.equals("Fish"))
            return new Fish();

        throw new IllegalArgumentException("There's no such an animal type");
    }
}
