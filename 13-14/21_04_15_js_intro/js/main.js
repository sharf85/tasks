console.log("Hello world")

function f1() {
    console.log("inside f1");
}

const a = 10;
let f2 = function (number) {
    return number * 2;
}
let b = f2(a);

console.log(`b equals to ${b}`)

b = f2;

console.log(b(a))

