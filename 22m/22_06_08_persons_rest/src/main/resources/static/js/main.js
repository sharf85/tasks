document.addEventListener("DOMContentLoaded", function () {
    const personTemplateDom = document.querySelector("#person-template");
    const personWrapperDom = document.querySelector("#person-wrapper");
    const personSearchDom = document.querySelector("#search-form");


    const personFormDom = document.querySelector("#person-form");

    const personClient = new PersonClient();
    const personRenderer = new PersonRenderer(personTemplateDom, personWrapperDom, personFormDom);
    const personService = new PersonService(personClient, personRenderer);

    const personWrapperListener = new PersonWrapperListener(personService);
    const personFormClickListener = new PersonFormClickListener(personService);
    const personSearchListener = new PersonSearchListener(personService);

    personFormDom.addEventListener("click", personFormClickListener);
    personWrapperDom.addEventListener("click", personWrapperListener);
    personSearchDom.addEventListener("click", personSearchListener);
});

const HOST = "http://localhost:8080/api/persons";

class PersonSearchListener {
    constructor(personService) {
        this.personService = personService;
    }

    handleEvent(event) {
        event.preventDefault();

        if (event.target.dataset.action) {
            this[event.target.dataset.action](event);
        } else {
            const buttonDom = event.target.closest("button");
            if (buttonDom) {
                this[buttonDom.dataset.action](event);
            }
        }
    }

    search(event) {
        const searchFormDom = event.currentTarget;
        const pattern = searchFormDom.elements.searchPattern.value;

        if (pattern.length >= 3)
            this.personService.search(pattern)
        else
            alert("Please, enter min 3 symbols");
    }


    refresh(event) {
        const searchFormDom = event.currentTarget;
        searchFormDom.elements.searchPattern.value = "";

        this.personService.cleanLoad();
    }

}


class PersonWrapperListener {

    constructor(personService) {
        this.personService = personService;
    }

    handleEvent(event) {
        event.preventDefault();

        const aDom = event.target.closest("a");

        if (aDom) {
            this[aDom.dataset.action](event);
        }
    }

    toggleDetails(event) {
        const personDom = event.target.closest(".person-item");
        this.personService.togglePersonDetails(personDom);
    }

    delete(event) {
        const personDom = event.target.closest(".person-item");
        this.personService.delete(personDom.person);
    }

    edit(event) {
        const personDom = event.target.closest(".person-item");
        this.personService.startEdit(personDom.person);
    }
}

// like controller in java web application
class PersonFormClickListener {

    constructor(personService) {
        this.personService = personService;
    }

    handleEvent(event) {
        event.preventDefault();

        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action](event);
        }
    }

    add(event) {
        const personFormDom = event.currentTarget;
        const person = {
            name: personFormDom.elements.name.value,
            lastname: personFormDom.elements.lastname.value,
            age: personFormDom.elements.age.value
        }
        this.personService.add(person);
    }

    edit(event) {
        const personFormDom = event.currentTarget;
        const person = {
            id: personFormDom.elements.id.value,
            name: personFormDom.elements.name.value,
            lastname: personFormDom.elements.lastname.value,
            age: personFormDom.elements.age.value
        }

        this.personService.completeEdit(person);
    }

    cancel(event) {
        this.personService.cancelEdit()
    }
}

class PersonService {
    constructor(client, renderer) {
        this.client = client;
        this.renderer = renderer;

        this.loadAll();
    }

    async loadAll() {
        const response = await this.client.getAll();
        if (response.ok) {
            const persons = await response.json();
            this.renderer.renderPersons(persons);
        }
    }

    cleanLoad() {
        this.renderer.clearAll();
        this.loadAll();
    }

    async search(pattern) {
        const response = await this.client.getAll();
        if (response.ok) {
            let persons = await response.json();
            persons = this.filterPersons(pattern, persons);
            this.renderer.clearAll();
            this.renderer.renderPersons(persons);
        }

    }

    filterPersons(pattern, persons) {
        pattern = pattern.toLowerCase();
        const res = [];
        for (let person of persons) {
            const name = person.name.toLowerCase();
            const lastname = person.lastname.toLowerCase();

            if (name.includes(pattern) || lastname.includes(pattern)) {
                res.push(person)
            }
        }
        return res;
    }

    togglePersonDetails(personDom) {
        this.renderer.togglePersonDetails(personDom);
    }

    async add(person) {
        const response = await this.client.add(person);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.clearForm();
            this.loadAll();
        }
    }

    async delete(person) {
        const response = await this.client.remove(person.id);
        if (response.ok) {
            this.renderer.clearAll();
            this.loadAll();
        }
    }

    startEdit(person) {
        this.renderer.toEditForm(person);
    }

    async completeEdit(person) {
        const response = await this.client.edit(person);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.toAddForm();
            this.loadAll();
        }
    }

    cancelEdit() {
        this.renderer.toAddForm();
    }
}

// to render html elements
class PersonRenderer {

    constructor(personTemplateDom, personWrapperDom, personFormDom) {
        this.personTemplateDom = personTemplateDom;
        this.personWrapperDom = personWrapperDom;
        this.personFormDom = personFormDom;

        this.addButtonDom = this.personFormDom.querySelector("button[data-action='add']")
        this.editButtonDom = this.personFormDom.querySelector("button[data-action='edit']")
        this.cancelButtonDom = this.personFormDom.querySelector("button[data-action='cancel']")
    }

    togglePersonDetails(personDom) {
        personDom.querySelector(".person-details").classList.toggle("hide");
    }

    renderPerson(person) {
        const personDom = this.personTemplateDom.cloneNode(true);
        personDom.person = person;

        personDom.removeAttribute("id");
        personDom.querySelector('span[data-id="name"]').innerHTML = person.name;
        personDom.querySelector('span[data-id="lastname"]').innerHTML = person.lastname;
        personDom.classList.remove("hide");

        // fill in user details
        personDom.querySelector(".name-value").innerHTML = person.name;
        personDom.querySelector(".second-name-value").innerHTML = person.lastname;
        personDom.querySelector(".age-value").innerHTML = person.age;

        this.personWrapperDom.append(personDom);
    }

    renderPersons(persons) {
        for (let person of persons) {
            this.renderPerson(person);
        }
    }

    clearAll() {
        this.personWrapperDom.innerHTML = ""
    }

    clearForm() {
        this.personFormDom.elements.id.value = "";
        this.personFormDom.elements.name.value = "";
        this.personFormDom.elements.lastname.value = "";
        this.personFormDom.elements.age.value = "";
    }

    toEditForm(person) {
        this.clearForm();
        this.addButtonDom.classList.add("hide");
        this.editButtonDom.classList.remove("hide");
        this.cancelButtonDom.classList.remove("hide");

        this.personFormDom.elements.id.value = person.id;
        this.personFormDom.elements.name.value = person.name;
        this.personFormDom.elements.lastname.value = person.lastname;
        this.personFormDom.elements.age.value = person.age;
    }

    toAddForm() {
        this.clearForm();
        this.addButtonDom.classList.remove("hide");
        this.editButtonDom.classList.add("hide");
        this.cancelButtonDom.classList.add("hide");
    }
}

// only for requesting the server
class PersonClient {

    getAll() {
        return fetch(HOST);
    }

    get(id) {

    }

    edit(person) {
        return fetch(HOST, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(person)
        });
    }

    add(person) {

        // fetch - for interacting with internet servers
        return fetch(HOST, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(person)
        });
    }

    remove(id) {
        return fetch(`${HOST}/${id}`, {
            method: 'DELETE',
        });
    }
}
