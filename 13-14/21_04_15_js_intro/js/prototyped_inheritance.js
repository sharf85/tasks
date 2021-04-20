function PrototypedAnimal(hasHair) {
    this.hasHair = hasHair;
}

PrototypedAnimal.prototype.makeSound = function () {
    console.log("animal sound");
}


let prototypedAnimal = new PrototypedAnimal(true);

function PrototypedRabbit(hasHair, earLength) {
    PrototypedAnimal.call(this, hasHair);
    this.earLength = earLength;
}

Object.setPrototypeOf(PrototypedRabbit.prototype, PrototypedAnimal.prototype);
// PrototypedRabbit.prototype.__proto__ = PrototypedAnimal.prototype;

let prototypedRabbit = new PrototypedRabbit(true, 20);


