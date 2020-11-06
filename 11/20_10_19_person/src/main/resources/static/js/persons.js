// we use the listener "main" here like the "main" method in Java
document.addEventListener("DOMContentLoaded", function main() {
    const personFormDom = document.getElementById("person-form");

    const personClient = new PersonClient();
    const personRenderer = new PersonRenderer();
    const personFormController = new PersonFormController(personClient, personRenderer);

    personFormDom.addEventListener("click", personFormController);
});

class PersonRenderer {
    renderAll(persons) {
//TODO render all persons
    }
}

class PersonFormController {

    constructor(personClient, personRenderer) {
        this.personClient = personClient;
        this.personRenderer = personRenderer;
    }

    handleEvent(event) {
        const actionName = event.target.dataset.action;
        if (actionName !== undefined)
            this[actionName](event);
    }

    async add(event) {
        const personFormDom = event.currentTarget;
        const name = personFormDom.elements.name;
        const secondName = personFormDom.elements.secondName;

        const person = {
            name: name.value,
            secondName: secondName.value
        }

        const response = await this.personClient.add(person);
        if (response.ok) {
            const allPersonsResponse = await this.personClient.getAll();
            const persons = await allPersonsResponse.json();
            console.log(persons);
            this.personRenderer.renderAll(persons);
        }
    }

    edit(event) {

    }

    cancel(event) {

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

    getAll() {
        return fetch(PersonClient.PERSONS_PATH);
    }

}


