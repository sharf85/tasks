// let name = "Name";
const constName = "Petya";

const arr = [2, "9", true];
arr[0] = -15

console.log(arr)

function mau() {
    console.log("Mau!!!");
}

let mauu = function () {
    console.log("Mauu!!!");
}

let anotherMau = mau;
anotherMau = mauu;
anotherMau = 1;

for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

for (let member of arr) {
    console.log(member);
}

// let vasyaCat = {}
// vasyaCat.name = "Vasya"
// vasyaCat.color = "gray"

// let vasyaCat = {
//     name: "Vasya",
//     color: "grey"
// }
//
// vasyaCat.mau = function () {
//     console.log("Mau!!!!!")
// };

let petyaCat = {
    name: "Petya",
    color: "black",
    bau: function () {
        console.log("Mau!!!!!")
    }
}

//this
let vasyaCat = {
    name: "Vasya",
    color: "grey",
}

vasyaCat.mau = function () {
    console.log("Mau!!! Ich bin " + this.name);
}

let mauWithoutContext = vasyaCat.mau;
mauWithoutContext();//no this

petyaCat.drau = mauWithoutContext;

petyaCat.drau();//this equals petyaCat
