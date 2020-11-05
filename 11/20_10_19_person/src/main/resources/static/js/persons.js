// we use the listener "main" here like the "main" method in Java
document.addEventListener("DOMContentLoaded", function main() {
    let addButton = document.getElementById("add-button");

    addButton.addEventListener("click", function () {
        alert("Hello plus button!");
    });
});
