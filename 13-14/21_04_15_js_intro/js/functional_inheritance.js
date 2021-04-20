function Animal(hasHair, suit) {

    Animal.animalNumber++;

    let _hasHair = hasHair;

    this.setHasHair = function (hasHair) {
        _hasHair = hasHair;
    }

    this.hasHair = function () {
        return _hasHair;
    }

    this.suit = suit;
}

function Rabbit(hasHair, suit, earsLength) {
    Animal.call(this, hasHair, suit);//calls the Animal function and injects 'this' as a context
    this.earsLength = earsLength;
}

let functionalRabbit = new Rabbit(true, "albino", 20);
