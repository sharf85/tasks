'use strict'

//starting point (like main in java)
document.addEventListener("DOMContentLoaded", function () {
    const contactFormDom = document.getElementById("contact-form");
    const contactWrapperDom = document.getElementById("contact-wrapper");

    const contactService = new ContactService(contactWrapperDom);
    const contactFormListener = new ContactFormListener(contactService, contactFormDom);

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

    }

    cancel(event) {

    }
}

//TODO the same stuff as above, but for working on the contact list. Perform remove functionality.
//a-la controller
class ContactListListener {

}

//powerful service
class ContactService {

    constructor(contactWrapperDom) {
        this.contactWrapperDom = contactWrapperDom;
        this._reInit();
    }

    async add(contact) {
        console.log(contact);
        const response = await fetch("/contact", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(contact)
        });
        if (response.ok)
            this._reInit();
    }

    edit(contact) {

    }

    remove(contact) {

    }

    async _reInit() {
        const contacts = await this._download();
        console.log(contacts);
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
        console.log(contact);
        const contactDom = document.createElement("li");
        contactDom.innerHTML =
            `<li class="collection-item">
            <div>

                <a href="/contact/${contact.id}"><span>${contact.name} ${contact.lastName}</span>
                </a>

                <span class="secondary-content">
                    <a href="">
                        <i class="material-icons teal-text text-darken-1">create</i>
                    </a>
                    <a href="">
                        <i class="material-icons  deep-orange-text text-darken-1">delete</i>
                    </a>
                </span>

            </div>
        </li>`;
        return contactDom;
    }
}