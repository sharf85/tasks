'use strict'

//starting point (like main in java)
document.addEventListener("DOMContentLoaded", function () {
    const contactFormDom = document.getElementById("contact-form");
    const contactWrapperDom = document.getElementById("contact-wrapper");

    const contactService = new ContactService(contactWrapperDom, contactFormDom);
    const contactFormListener = new ContactFormListener(contactService, contactFormDom);
    const contactListListener = new ContactListListener(contactService);

    contactWrapperDom.addEventListener("click", contactListListener);
    contactFormDom.addEventListener("click", contactFormListener);
});

//a-la controller
class ContactFormListener {
    constructor(contactService, contactFormDom) {
        this.contactService = contactService;
        this.contactFormDom = contactFormDom;
    }

    handleEvent(event) {
        const action = event.target.dataset.action;
        if (action === undefined)
            return;

        this[action](event);
    }

    add(event) {
        event.preventDefault();
        const data = {
            "name": this.contactFormDom.elements.name.value,
            "lastName": this.contactFormDom.elements.lastName.value,
        }
        this.contactService.add(data);
    }

    edit(event) {
        event.preventDefault();
        const data = {
            id: this.contactFormDom.elements.id.value,
            name: this.contactFormDom.elements.name.value,
            lastName: this.contactFormDom.elements.lastName.value,
        }
        this.contactService.edit(data);
    }

    cancel(event) {
        event.preventDefault();
        this.contactService.toAddForm();
    }
}

//a-la controller
class ContactListListener {
    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        console.log(event.target)
        const action = event.target.dataset.action;
        if (action === undefined)
            return;

        this[action](event);
    }

    edit(event) {
        event.preventDefault();
        const editButtonDom = event.target;
        const contactDom = editButtonDom.closest("li.collection-item")
        console.log(contactDom.contact);
        this.contactService.toEditForm(contactDom.contact);
    }

    remove(event) {
        event.preventDefault();
        const removeButtonDom = event.target;
        const contactDom = removeButtonDom.closest("li.collection-item")
        this.contactService.remove(contactDom.contact);
    }
}

//powerful service
class ContactService {

    constructor(contactWrapperDom, contactFormDom) {
        this.contactWrapperDom = contactWrapperDom;
        this.contactFormDom = contactFormDom;

        this.editFormButton = contactFormDom.querySelector('[data-action="edit"]')
        this.addFormButton = contactFormDom.querySelector('[data-action="add"]')
        this.cancelFormButton = contactFormDom.querySelector('[data-action="cancel"]')

        this._reInit();
    }

    async add(contact) {
        const response = await fetch("/contact", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(contact)
        });
        if (response.ok) {
            this._clearForm();
            this._reInit();
        }
    }

    async edit(contact) {
        const response = await fetch("/contact", {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(contact)
        });
        if (response.ok) {
            this._clearForm();
            this._reInit();
            this.toAddForm();
        }
    }

    toEditForm(contact) {
        this.contactFormDom.elements.id.value = contact.id;
        this.contactFormDom.elements.name.value = contact.name;
        this.contactFormDom.elements.lastName.value = contact.lastName;

        this.addFormButton.style.display = "none";
        this.editFormButton.style.display = "block";
        this.cancelFormButton.style.display = "block";
    }

    toAddForm() {
        this._clearForm();

        this.addFormButton.style.display = "block";
        this.editFormButton.style.display = "none";
        this.cancelFormButton.style.display = "none";
    }

    async remove(contact) {
        const response = await fetch(`contact/${contact.id}`, {
            method: "DELETE"
        })
        if (response.ok)
            this._reInit();
    }

    _clearForm() {
        this.contactFormDom.elements.id.value = "";
        this.contactFormDom.elements.name.value = "";
        this.contactFormDom.elements.lastName.value = "";
    }

    async _reInit() {
        const contacts = await this._download();
        this._renderContacts(contacts);
    }

    async _download() {
        const response = await fetch("/contact");
        return response.json();
    }

    _renderContacts(contacts) {
        this.contactWrapperDom.innerHTML = "";
        const firstLi = document.createElement("li");
        firstLi.className = "collection-header";
        firstLi.innerHTML = "<h4>Contacts</h4>";

        this.contactWrapperDom.append(firstLi);

        for (let contact of contacts) {
            this.contactWrapperDom.append(this._renderContact(contact));
        }
    }

    _renderContact(contact) {
        const contactDom = document.createElement("li");
        contactDom.className = "collection-item";
        contactDom.contact = contact;
        contactDom.innerHTML =
            `
            <div>

                <a href="/contact/${contact.id}"><span>${contact.name} ${contact.lastName}</span>
                </a>

                <span class="secondary-content">
                    <a href="">
                        <i class="material-icons teal-text text-darken-1" data-action="edit">create</i>
                    </a>
                    <a href="">
                        <i class="material-icons  deep-orange-text text-darken-1" data-action="remove">delete</i>
                    </a>
                </span>

            </div>
        `;
        return contactDom;
    }
}