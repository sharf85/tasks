// we use the listener "main" here like the "main" method in Java
document.addEventListener("DOMContentLoaded", function main() {
    const personFormDom = document.getElementById("person-form");
    const instantPerson = document.getElementById("person-template");
    const personWrapper = document.getElementById("persons-wrapper");

    const personClient = new PersonClient();
    const personRenderer = new PersonRenderer(instantPerson, personWrapper, personFormDom);
    const personWrapperController = new PersonWrapperController(personRenderer, personClient);
    const personFormController = new PersonFormController(personClient, personRenderer);

    personFormDom.addEventListener("click", personFormController);
    personWrapper.addEventListener("click", personWrapperController);
});

const REAL_PERSON_CLASS = "real-person";

class PersonRenderer {

    constructor(instantPerson, personWrapper, personForm) {
        this.instantPerson = instantPerson
        this.personWrapper = personWrapper;
        this.personForm = personForm;

        this.addButton = document.getElementById("add-button");
        this.editButton = document.getElementById("edit-button");
        this.cancelButton = document.getElementById("cancel-button");
    }

    renderAll(persons) {
        this.removeAll();
        for (let person of persons) {
            let personDom = this.renderPerson(person);
            this.personWrapper.append(personDom);
        }
    }

    removeAll() {
        let personsDom = this.personWrapper.querySelectorAll(`.${REAL_PERSON_CLASS}`);
        for (let personDom of personsDom) {
            personDom.remove();
        }
    }

    renderPerson(person) {
        const res = this.instantPerson.cloneNode(true);
        res.person = person;
        res.classList.remove("hide");
        res.classList.add(REAL_PERSON_CLASS);
        const personDetailsLink = res.querySelector(".person-details-link");
        personDetailsLink.innerHTML = `${person.name} ${person.secondName}`;

        res.querySelector(".name-value").innerHTML = person.name;
        res.querySelector(".second-name-value").innerHTML = person.secondName;
        res.querySelector(".age-value").innerHTML = person.age;

        return res;
    }

    clearForm() {
        this.personForm.elements.id.value = "";
        this.personForm.elements.name.value = "";
        this.personForm.elements.secondName.value = "";
        this.personForm.elements.age.value = "";
    }

    toEditForm(person) {
        this.personForm.elements.id.value = person.id;
        this.personForm.elements.name.value = person.name;
        this.personForm.elements.secondName.value = person.secondName;
        this.personForm.elements.age.value = person.age;

        this.addButton.classList.add("hide");
        this.editButton.classList.remove("hide");
        this.cancelButton.classList.remove("hide");
    }

    toAddForm(person) {
        this.clearForm();

        this.addButton.classList.remove("hide");
        this.editButton.classList.add("hide");
        this.cancelButton.classList.add("hide");
    }

    togglePersonDetails(personDom) {
        const personDetailsDom = personDom.querySelector(".person-details");
        personDetailsDom.classList.toggle("hide");
    }
}

class PersonWrapperController {

    constructor(personRenderer, personClient) {
        this.personRenderer = personRenderer;
        this.personClient = personClient;
    }

    handleEvent(event) {
        const actionName = event.target.dataset.action;
        if (actionName !== undefined)
            this[actionName](event);
    }

    toggleDetails(event) {
        let personDom = event.target.closest(`.${REAL_PERSON_CLASS}`);
        this.personRenderer.togglePersonDetails(personDom);
    }

    async remove(event) {
        let personDom = event.target.closest(`.${REAL_PERSON_CLASS}`);
        let removeResponse = await this.personClient.remove(personDom.person);
        if (removeResponse.ok) {
            const allPersonsResponse = await this.personClient.getAll();
            if (allPersonsResponse.ok) {
                const persons = await allPersonsResponse.json();
                this.personRenderer.renderAll(persons);
            }
        }
    }

    edit(event) {
        let personDom = event.target.closest(`.${REAL_PERSON_CLASS}`);
        this.personRenderer.toEditForm(personDom.person);
    }
}

class PersonFormController {

    constructor(personClient, personRenderer) {
        this.personClient = personClient;
        this.personRenderer = personRenderer;
        this._init();
    }

    async _init() {
        const allPersonsResponse = await this.personClient.getAll();
        if (allPersonsResponse.ok) {
            const persons = await allPersonsResponse.json();
            this.personRenderer.renderAll(persons);
        }
    }

    handleEvent(event) {
        const actionName = event.target.dataset.action;
        if (actionName !== undefined)
            this[actionName](event);
        event.stopPropagation();
    }

    async add(event) {
        const personFormDom = event.currentTarget;

        const person = {
            name: personFormDom.elements.name.value,
            secondName: personFormDom.elements.secondName.value,
            age: personFormDom.elements.age.value,
        }

        const response = await this.personClient.add(person);
        if (response.ok) {
            await this._init();
        }
        this.personRenderer.clearForm();
    }

    async edit(event) {
        const personFormDom = event.currentTarget;

        const person = {
            id: personFormDom.elements.id.value,
            name: personFormDom.elements.name.value,
            secondName: personFormDom.elements.secondName.value,
            age: personFormDom.elements.age.value,
        }

        const response = await this.personClient.edit(person);
        if (response.ok) {
            await this._init();
        }
        this.personRenderer.toAddForm();
    }

    cancel(event) {
        this.personRenderer.toAddForm();
    }
}

class PersonClient {
    static PERSONS_PATH = "/api/persons";

    add(person) {
        return fetch(PersonClient.PERSONS_PATH, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(person)
        });
    }

    edit(person) {
        return fetch(`${PersonClient.PERSONS_PATH}/${person.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(person)
        });

    }

    remove(person) {
        return fetch(`${PersonClient.PERSONS_PATH}/${person.id}`, {
            method: 'DELETE'
        });
    }

    getAll() {
        return fetch(PersonClient.PERSONS_PATH);
    }

}


