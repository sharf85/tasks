let addButton = document.querySelector("#add-contact-button");
addButton.addEventListener("click", function (event) {
    event.preventDefault();
    this.innerHTML = "No Add!";
});