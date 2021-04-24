document.addEventListener("DOMContentLoaded", function () {
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");


    const contactFormDom = document.querySelector("#contact-form");

    const contactClient = new ContactClient();
    const contactRenderer = new ContactRenderer(contactTemplateDom, contactWrapperDom, contactFormDom);
    const contactService = new ContactService(contactClient, contactRenderer);

    const contactWrapperListener = new ContactWrapperListener(contactService);
    const contactFormClickListener = new ContactFormClickListener(contactService);

    contactFormDom.addEventListener("click", contactFormClickListener);
    contactWrapperDom.addEventListener("click", contactWrapperListener)
});

const HOST = "http://localhost:8080/api/contacts";

class ContactWrapperListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        event.preventDefault();

        const aDom = event.target.closest("a");

        if (aDom) {
            this[aDom.dataset.action](event);
        }
    }

    toggleDetails(event) {
        // alert("details");
        //TODO clicking on the contact the user should see the details of the contact. In order to do this one
        // should perform the following:
        // add html code with the details into contact template. Hide/open it while clicking on the name of the contact.
    }

    delete(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactService.delete(contactDom.contact);
    }

    edit(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactService.startEdit(contactDom.contact);
    }
}

// like controller in java web application
class ContactFormClickListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        event.preventDefault();

        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action](event);
        }
    }

    add(event) {
        const contactFormDom = event.currentTarget;
        const contact = {
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }
        this.contactService.add(contact);
    }

    edit(event) {
        const contactFormDom = event.currentTarget;
        const contact = {
            id: contactFormDom.elements.id.value,
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }

        this.contactService.completeEdit(contact);
    }

    cancel(event) {
        this.contactService.cancelEdit()
    }
}

class ContactService {
    constructor(client, renderer) {
        this.client = client;
        this.renderer = renderer;

        this.loadAll();
    }

    async loadAll() {
        const response = await this.client.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.renderer.renderContacts(contacts);
        }
    }

    async add(contact) {
        const response = await this.client.add(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.clearForm();
            this.loadAll();
        }
    }

    async delete(contact) {
        const response = await this.client.remove(contact.id);
        if (response.ok) {
            this.renderer.clearAll();
            this.loadAll();
        }
    }

    startEdit(contact) {
        this.renderer.toEditForm(contact);
    }

    async completeEdit(contact) {
        const response = await this.client.edit(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.toAddForm();
            this.loadAll();
        }
    }

    cancelEdit(){
        //TODO complete. Just transfer the from into adding state.
    }
}

// to render html elements
class ContactRenderer {

    constructor(contactTemplateDom, contactWrapperDom, contactFormDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
        this.contactFormDom = contactFormDom;

        this.addButtonDom = this.contactFormDom.querySelector("button[data-action='add']")
        this.editButtonDom = this.contactFormDom.querySelector("button[data-action='edit']")
        this.cancelButtonDom = this.contactFormDom.querySelector("button[data-action='cancel']")
    }

    renderContact(contact) {
        const contactDom = this.contactTemplateDom.cloneNode(true);
        contactDom.contact = contact;

        contactDom.removeAttribute("id");
        contactDom.querySelector('span[data-id="name"]').innerHTML = contact.name;
        contactDom.querySelector('span[data-id="lastname"]').innerHTML = contact.lastName;
        contactDom.classList.remove("hide");

        this.contactWrapperDom.append(contactDom);
    }

    renderContacts(contacts) {
        for (let contact of contacts) {
            this.renderContact(contact);
        }
    }

    clearAll() {
        this.contactWrapperDom.innerHTML = ""
    }

    clearForm() {
        this.contactFormDom.elements.id.value = "";
        this.contactFormDom.elements.name.value = "";
        this.contactFormDom.elements.lastName.value = "";
        this.contactFormDom.elements.age.value = "";
    }

    toEditForm(contact) {
        this.clearForm();
        this.addButtonDom.classList.add("hide");
        this.editButtonDom.classList.remove("hide");
        this.cancelButtonDom.classList.remove("hide");

        this.contactFormDom.elements.id.value = contact.id;
        this.contactFormDom.elements.name.value = contact.name;
        this.contactFormDom.elements.lastName.value = contact.lastName;
        this.contactFormDom.elements.age.value = contact.age;
    }

    toAddForm() {
        this.clearForm();
        this.addButtonDom.classList.remove("hide");
        this.editButtonDom.classList.add("hide");
        this.cancelButtonDom.classList.add("hide");
    }
}

// only for requesting the server
class ContactClient {

    getAll() {
        return fetch(HOST);
    }

    get(id) {

    }

    edit(contact) {
        return fetch(HOST, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    add(contact) {

        // fetch - for interacting with internet servers
        return fetch(HOST, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    remove(id) {
        return fetch(`${HOST}/${id}`, {
            method: 'DELETE',
        });
    }
}
