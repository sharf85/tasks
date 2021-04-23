document.addEventListener("DOMContentLoaded", function () {
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");


    const contactFormDom = document.querySelector("#contact-form");

    const contactClient = new ContactClient();
    const contactRenderer = new ContactRenderer(contactTemplateDom, contactWrapperDom);

    const contactService = new ContactService(contactClient, contactRenderer);
    const contactFormClickListener = new ContactFormClickListener(contactService);
    contactFormDom.addEventListener("click", contactFormClickListener);
});

const HOST = "http://localhost:8080/api/contacts";

// like controller in java web application
class ContactFormClickListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        event.preventDefault();

        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action]();
        }
    }

    //TODO implement. The method must retrieve all the inputs from the form (4.1 in the book), compose the object
    // based on the inputs. {name: "name", "lastName": lastName, ...} Then call the method service.add(contact)
    add(event) {
        //...
        this.contactService.add(contact);
    }

    edit(event) {
        alert("edit")
    }

    cancel(event) {
        alert("cancel")
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

    add(contact) {
        //TODO call the client to send the new contact to the server and then remove all old contacts from the contact
        //wrapper in html and fetch all contacts from the server again and then render them all.
    }

}

// to render html elements
class ContactRenderer {

    constructor(contactTemplateDom, contactWrapperDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
    }

    renderContact(contact) {
        const contactDom = this.contactTemplateDom.cloneNode(true);
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

    //TODO the method must clear the contactTemplateDom (remove all contacts)
    clearAll() {

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

    }
}
