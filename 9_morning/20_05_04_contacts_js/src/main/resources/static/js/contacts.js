// like main() method in Java
document.addEventListener("DOMContentLoaded", function main() {
    const contactFormDom = document.getElementById("contact-form");
    const contactWrapperDom = document.getElementById("contact-wrapper");

    const contactService = new ContactService(contactWrapperDom, contactFormDom);
    const contactFormListener = new ContactFormListener(contactService);
    const contactWrapperListener = new ContactWrapperListener(contactService);

    contactFormDom.addEventListener("click", contactFormListener);
    contactWrapperDom.addEventListener("click", contactWrapperListener);

});

// like a controller in Java
class ContactFormListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        const action = event.target.dataset.action;
        if (action !== undefined)
            this[action](event);//this.add()//this["add"]()}
    }

    addContact(event) {
        event.preventDefault();
        const contactFormDom = event.currentTarget;
        const contact = {
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }

        this.contactService.addContact(contact);
    }

    editContact(event) {
        event.preventDefault();

        const contactFormDom = event.currentTarget;
        const contact = {
            id: contactFormDom.elements.id.value,
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }
        this.contactService.editContact(contact);
    }

    cancelEditing(event) {
        event.preventDefault();
        this.contactService.switchToAddForm();
    }
}

class ContactWrapperListener {
    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {

        const action = event.target.dataset.action;
        if (action !== undefined)
            this[action](event);//this.add()//this["add"]()}
    }

    removeContact(event) {
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item");
        const contactId = contactDom.contact.id;
        this.contactService.removeById(contactId);
    }

    editContact(event) {
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item");
        this.contactService.switchToEditForm(contactDom.contact);
    }

    toggleContact(event) {
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item");
        this.contactService.toggleContactDom(contactDom);
    }
}

//like a service in Java
class ContactService {

    constructor(contactWrapperDom, contactFormDom) {
        this.contactWrapperDom = contactWrapperDom;
        this.contactFormDom = contactFormDom;

        this.addButtonDom = contactFormDom.querySelector('[data-action="addContact"]');
        this.editButtonDom = contactFormDom.querySelector('[data-action="editContact"]');
        this.cancelButtonDom = contactFormDom.querySelector('[data-action="cancelEditing"]');
        this._reInit();
    }

    //sends data of a new contact to the server and updates the list of contacts
    async addContact(contact) {
        const response = await fetch("/contact", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        })

        if (response.ok) {
            this._reInit();
            this.clearForm();
        }

    }

    //sends data an existing contact to the server and updates the list of contacts
    async editContact(contact) {
        const response = await fetch("/contact", {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        })

        if (response.ok) {
            this._reInit();
            this.switchToAddForm();
        }
    }

    //sends a request to the server to remove the contact and update the list of contacts
    //TODO implement
    async removeById(id) {
        const response = await fetch(`/contact/${id}`, {
            method: 'DELETE',
        })

        if (response.ok) {
            this._reInit();
        }
    }

    switchToEditForm(contact) {
        this.contactFormDom.elements.id.value = contact.id;
        this.contactFormDom.elements.name.value = contact.name;
        this.contactFormDom.elements.lastName.value = contact.lastName;
        this.contactFormDom.elements.age.value = contact.age;

        this.addButtonDom.style.display = "none";
        this.editButtonDom.style.display = "block";
        this.cancelButtonDom.style.display = "block";
    }

    switchToAddForm() {
        this.clearForm();

        this.addButtonDom.style.display = "block";
        this.editButtonDom.style.display = "none";
        this.cancelButtonDom.style.display = "none";
    }

    clearForm() {
        this.contactFormDom.elements.id.value = "";
        this.contactFormDom.elements.name.value = "";
        this.contactFormDom.elements.lastName.value = "";
        this.contactFormDom.elements.age.value = "";
    }

    toggleContactDom(contactDom) {
        const contactDataDom = contactDom.querySelector(".contact-data");
        contactDataDom.classList.toggle("hide");
    }

    async _reInit() {
        const contacts = await this._downloadContacts();
        this._renderContacts(contacts);
    }

    async _downloadContacts() {
        const response = await fetch("/contact");
        return response.json();
    }

    _renderContacts(contacts) {
        this.contactWrapperDom.innerHTML = "";
        const collectionHeader = document.createElement("li");
        collectionHeader.className = "collection-header";
        collectionHeader.innerHTML = "<h4>Contacts</h4>";

        this.contactWrapperDom.append(collectionHeader);

        for (let contact of contacts) {
            const contactDom = this._renderContact(contact);
            this.contactWrapperDom.append(contactDom);
        }
    }

    _renderContact(contact) {
        const contactDom = document.createElement("li");
        contactDom.className = "collection-item";
        contactDom.contact = contact;
        contactDom.innerHTML =
            `<div>
                <a href="" >
                    <span data-action="toggleContact">${contact.name} ${contact.lastName}</span>
                </a>
                <span class="secondary-content">
                    <a href="">
                    <i data-action="editContact" class="material-icons teal-text text-darken-1">create</i></a>
                    <a href="">
                        <i data-action="removeContact" class="material-icons  deep-orange-text text-darken-1">delete</i></a>
                </span>
                
                ${this._renderContactData(contact)}
            </div>`;
        return contactDom;
    }

    _renderContactData(contact) {
        return `<ul class="collection contact-data hide">
                    <li class="collection-item">
                        <div>Name<span class="secondary-content blue-text text-darken-1" >${contact.name}</span>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div>Last Name<span class="secondary-content blue-text text-darken-1">${contact.lastName}</span>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div>Age<span class="secondary-content blue-text text-darken-1">${contact.age}</span>
                        </div>
                    </li>
                </ul>`
    }
}
