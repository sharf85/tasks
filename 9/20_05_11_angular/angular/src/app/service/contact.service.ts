import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';

@Injectable()
export class ContactService {
  contacts: Contact[];

  constructor() {
    this.contacts = contacts;
  }

  add(contact: Contact): void {
    contact.id = this.contacts.length + 1;
    const objectToAdd: Contact = Object.assign({}, contact);
    this.contacts.push(objectToAdd);
  }

  getAll(): Contact[] {
    return this.contacts;
  }

  remove(childContact: Contact) {
    this.contacts = this.contacts.filter(value => value.id !== childContact.id);
  }

  edit(contact: Contact) {
    const contactToEdit: Contact = this.contacts.find(value => value.id === contact.id);
    Object.assign(contactToEdit, contact);
  }
}

const contacts: Contact[] = [
  {id: 1, name: 'Vasya', lastName: 'Vasin', age: 20},
  {id: 2, name: 'Petya', lastName: 'Vasin', age: 22},
  {id: 3, name: 'Masha', lastName: 'Vasina', age: 21},
  {id: 4, name: 'Tanya', lastName: 'Vasina', age: 19},
  {id: 5, name: 'Tel', lastName: 'Ranov', age: 25},
];
