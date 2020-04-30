function makeCat(name, color) {
    let newCat = {};

    newCat.name = name;
    newCat.color = color;
    newCat.mau = function () {
        console.log("Mau!!! Ich bin " + newCat.name);
    }

    return newCat;
}

let vasyaCat = makeCat("Vasya", "grey");

function Animal() {
    this.eat = function () {
        console.log("eating");
    }
}

function Cat(name, color) {
    Animal.apply(this, arguments)
    this.name = name;
    this.color = color;
    this.mau = function () {
        console.log("Mau!!! Ich bin " + this.name);
    }
}

let vasya = new Cat("Vasya", "grey")

class CatClass {
    name = "Vas";

    constructor(name, color) {
        this.name = name;
        this.color = color;
    }

    mau() {
        console.log("Mau!!! Ich bin " + this.name);
    }
}

let vasyaClass = new CatClass("Vasya", "grey");

//function with some context
function sayName() {
    console.log(`My name is ${this.name}`);
}

sayName()

let human = {
    name: "Humanoid"
}
// human.declare = sayName

let petyaHuman = {
    name: "Petya"
}

let objectWithoutName = {
    color: "grey"
}

sayName.call(human)//Humanoid
sayName.call(petyaHuman)//Petya
sayName.call(objectWithoutName)//undefined

