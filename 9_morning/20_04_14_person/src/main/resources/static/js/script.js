console.log("Hello world");

let name = "Vasya";
name = 1;

let isSomething = true;
isSomething = false;

function concat(name, lastName) {
    return name + lastName;
}

let sum = function (a1, a2) {
    return a1 + a2;
};

let anotherFunc = sum;
anotherFunc = concat;

anotherFunc(10, 15);

let arr = [1, 5, 10];

console.log(fullName("Vasily", "Terkin"));

