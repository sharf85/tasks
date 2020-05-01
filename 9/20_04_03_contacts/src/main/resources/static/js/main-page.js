'use strict'
let addButton = document.querySelector("#add-contact-button");

let onClickAddButton = function (event) {
    console.log("Clicked on the button itself");
    event.preventDefault();
    this.classList.toggle("blue");
    if (this.classList.contains("blue")) {
        this.classList.remove("red");
    } else {
        this.classList.add("red");
    }
}

addButton.addEventListener("click", onClickAddButton);
addButton.parentElement.addEventListener("click", function (event) {
    console.log("Clicked on the button container");
});
window.variable = "My variable"