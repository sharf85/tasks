function contacts() {
    const addFormDom = document.getElementById("add-contact-form");
    addFormDom.addEventListener("submit", addContact);

    function addContact(event) {
        event.preventDefault();
        const formData = new FormData(addFormDom);

        fetch("/contact",
            {
                method: 'POST',
                body: formData
            }
        ).then(response => {
            console.log(response.json());
        }).catch(error => console.log(error));
    }

}

document.addEventListener("DOMContentLoaded", contacts);