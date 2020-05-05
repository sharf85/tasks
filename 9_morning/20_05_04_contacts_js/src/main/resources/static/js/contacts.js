// like main() method in Java
document.addEventListener("DOMContentLoaded", function main() {
    const contactFormDom = document.getElementById("contact-form");
    const contactWrapperDom = document.getElementById("contact-wrapper");

    const contactService = new ContactService(contactWrapperDom);
    const contactFormListener = new ContactFormListener(contactService);

    contactFormDom.addEventListener("click", contactFormListener);

});

// like a controller in Java
class ContactFormListener {

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        event.preventDefault();
        const action = event.target.dataset.action;
        if (action !== undefined)
            this[action](event);//this.add()//this["add"]()}
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

    }

    cancel(event) {

    }
}

class ContactWrapperListener {
    constructor(contactService) {
        this.contactService = contactService;
    }

    //TODO implement
    remove() {

    }

    edit() {

    }
}

//like a service in Java
class ContactService {

    constructor(contactWrapperDom) {
        this.contactWrapperDom = contactWrapperDom;
        this._reInit();
    }

    //sends data of a new contact to the server and updates the list of contacts
    async add(contact) {
        const response = await fetch("/contact", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        })

        if (response.ok) {
            this._reInit();
        }

    }

    //sends data an existing contact to the server and updates the list of contacts
    edit(contact) {

    }

    //sends a request to the server to remove the contact and update the list of contacts
    //TODO implement
    removeById(id) {

        this._reInit();
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
        contactDom.dataset.contact = contact;
        contactDom.innerHTML =
            `<div>
                <a href="/contact/${contact.id}">
                    <span>${contact.name} ${contact.lastName}</span>
                </a>
                <span class="secondary-content">
                    <a href="" data-action="edit"><i class="material-icons teal-text text-darken-1">create</i></a>
<!--                    to get somewhere id of the contact to remove-->
                    <a href="" data-action="delete" data-action="id">
                        <i class="material-icons  deep-orange-text text-darken-1">delete</i></a>
                </span>
            </div>`;
        return contactDom;
    }

}