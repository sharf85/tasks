// window.anotherGlobal = "pampam"
// var some = "some"
//
// function someFunction() {
//     for (let i = 0; i < 10; i++) {
//         if (i === 9)
////             var variables are visible all over the function they declared
// var variable = 15;
// }
//
// console.log(variable);
// }

// let addButton = document.getElementById("add-btn")
let addButton = document.querySelector("#add-btn")

// let onAddButtonClick = function(event){
//
// }
addButton.addEventListener("click", function (event) {
    event.preventDefault();//cancels redirect
    addButton.innerHTML = "No Add!";
})