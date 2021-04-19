// console.log("Hello world")
//
// function f1() {
//     console.log("inside f1");
// }
//
// const a = 10;
// let f2 = function (number) {
//     return number * 2;
// }
// let b = f2(a);
//
// console.log(`b equals to ${b}`)
//
// b = f2;
//
// console.log(b(a))
//
// // objects and functions
//
// vasya = {
//     name: "Vasya",
//     "age": 23,
//     "hello": "Ivan Ivanych",
//     "hello world": "Petr Petrovich",
//     // greetings: function () {
//     //     console.log(this.name)
//     // },
//     greetings() {
//         console.log(`My name is ${this.name}`)
//     }
// }
// const fieldName = "greetings"
// vasya[fieldName]();
//
// console.log(vasya["hello world"])
// vasya["hello class"] = "Good morning, dear classmates!"
// console.log(vasya.hairColor)//undefined
// console.log(vasya['hello class'])//"Good morning, dear classmates!"
//
// function passObject(obj) {
//     for (let field in obj) {
//         console.log(`${field}: ${obj[field]}`)
//     }
// }
//
// passObject(vasya)
//
//
//
//
//

// window.name = "Vasya1";//window.name = "vasya"
// let name = "Vasya2";//error


let petya = {
    vorname: "Petya",
    greetings: function () {
        let sayName = () => {
            return this.vorname;//this == window, if without context
        }

        let toSay = "Hello " + sayName();
        console.log(toSay);
    }
}

petya.greetings();//Hello petya

let anotherGreetings = petya.greetings;

anotherGreetings()//Hello undefined
// petya.saySome = sayName;
console.log(window.vorname)
