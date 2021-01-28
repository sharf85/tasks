document.addEventListener("DOMContentLoaded", function main() {
    const formDom = document.querySelector("#contact-form");
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");

    const contactClient = new ContactClient();
    const contactRenderer = new ContactRenderer(contactTemplateDom, contactWrapperDom);

    const formController = new FormController(contactClient, contactRenderer);


    formDom.addEventListener("click", formController);
});

const REAL_CONTACT_CLASS = "real-contact";

class FormController {

    constructor(contactClient, contactRenderer) {
        this.contactClient = contactClient;
        this.contactRenderer = contactRenderer;
        this._init();
    }

    async _init() {
        const response = await this.contactClient.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.contactRenderer.renderContacts(contacts);
        }
    }

    handleEvent(event) {
        const action = event.target.dataset.action
        if (action !== undefined)
            this[action](event);
    }

    async add(event) {
        const formDom = event.currentTarget;

        const contact = {
            name: formDom.elements.name.value,
            lastName: formDom.elements.lastName.value,
            age: formDom.elements.age.value,
        };

        const response = await this.contactClient.add(contact);
        if (response.ok) {
            this._init();
        }

    }

    edit(event) {

    }

    cancel(event) {

    }
}

class ContactRenderer {

    constructor(contactTemplateDom, contactWrapperDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
    }

    renderContacts(contacts) {

        console.log("render");
        this.removeAll();
        for (let contact of contacts) {
            let contactDom = this.renderContact(contact);
            this.contactWrapperDom.append(contactDom);
        }
    }

    removeAll() {
        let contactsDom = this.contactWrapperDom.querySelectorAll(`.${REAL_CONTACT_CLASS}`);
        for (let contactDom of contactsDom) {
            contactDom.remove();
        }
    }

    renderContact(contact) {
        const res = this.contactTemplateDom.cloneNode(true);
        res.contact = contact;
        res.classList.remove("hide");
        res.classList.add(REAL_CONTACT_CLASS);
        const contactDetailsLink = res.querySelector(".contact-details-link");
        contactDetailsLink.innerHTML = `${contact.name} ${contact.lastName}`;

        res.querySelector(".name-value").innerHTML = contact.name;
        res.querySelector(".second-name-value").innerHTML = contact.lastName;
        res.querySelector(".age-value").innerHTML = contact.age;

        return res;
    }

}

class ContactClient {
    static CONTACTS_PATH = "/api/contacts";

    add(contact) {
        return fetch(ContactClient.CONTACTS_PATH, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    getAll() {
        return fetch(ContactClient.CONTACTS_PATH, {
            method: 'GET',
        });

    }
}
