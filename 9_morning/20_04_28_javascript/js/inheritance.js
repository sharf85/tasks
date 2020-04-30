//objects inherit objects
let vasyaAnimal = {
    name: "Vasya"
}

let vasyaCat = {
    color: "grey",
    __proto__: vasyaAnimal
}

//inheritance with functions
function Animal(name) {
    this.name = name;
}

Animal.prototype.eat = function () {
    console.log("eating!!!");
}

function Cat(name, color) {
    let newCat = this;
    Animal.call(newCat, name);
    this.color = color;
}

Cat.prototype.mau = function () {
    console.log(`Mau!!! Ich bin ${this.name}`)
}
Cat.prototype.__proto__ = Animal.prototype

let anotherCat = new Cat("Petr", "black")

//inheritance with classes

class AnimalClass {
    constructor(name) {
        this.name = name;
    }

    eat() {
        console.log("eating!!!!")
    }
}

class CatClass extends AnimalClass {
    constructor(name, color) {
        super(name);
        this.color = color;
    }

    mau() {
        console.log(`Mau!!! Ich bin ${this.name}`)
    }
}
