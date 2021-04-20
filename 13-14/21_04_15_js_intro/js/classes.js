class AnimalClass {

    static animalNumber = 0;

    static incrementAnimals() {
        AnimalClass.animalNumber++;
    }

    _hasHair = false;

    constructor(hasHair) {
        AnimalClass.incrementAnimals();
        this._hasHair = hasHair;
    }

    getHair() {
        return this._hasHair;
    }

}

let animalFromClass = new AnimalClass(true);

class RabbitClass extends AnimalClass {

    #earLength;

    constructor(hasHair, earLength) {
        super(hasHair);
        this.#earLength = earLength;
    }

    getEarLength() {
        return this.#earLength;
    }

    #somethingVeryPrivate() {
        console.log("privat-private");
    }
}

let rabbitFromClass = new RabbitClass(true, 20);
