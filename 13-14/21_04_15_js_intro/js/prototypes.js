const animal = {
    hasHair: true
}

const rabbit = {
    earsLength: 20,
    __proto__: animal
}

// Object.setPrototypeOf(rabbit, animal)
// rabbit.__proto__ = animal


