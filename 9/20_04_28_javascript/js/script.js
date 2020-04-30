let a = 0;
const b = 12;
let c;//undefined

//1
let cat = {}
cat.name = "Vasya"
cat.color = "grey"

//2
cat = {
    name: "Petr",
    color: "grey"
}

//no need to be the same kind of the object
// cat = 1;

//Functions
let age = 5;

function mau() {
    console.log(age);
    console.log("Mau!!! I am " + this.name);
}

cat.mauau = mau;
cat = {
    name: "Petr",
    color: "grey",
}
