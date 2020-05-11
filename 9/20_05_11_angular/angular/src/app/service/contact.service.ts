import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';

@Injectable()
export class ContactService {
  contacts: Contact[];

  constructor() {
    this.contacts = contacts;
  }

  add(contact: Contact): void {
    this.contacts.push(contact);
  }

  getAll(): Contact[] {
    return this.contacts;
  }

}

const contacts: Contact[] = [
  {id: 1, name: 'Vasya', lastName: 'Vasin', age: 20},
  {id: 2, name: 'Petya', lastName: 'Vasin', age: 22},
  {id: 3, name: 'Masha', lastName: 'Vasina', age: 21},
  {id: 4, name: 'Tanya', lastName: 'Vasina', age: 19},
  {id: 5, name: 'Tel', lastName: 'Ranov', age: 25},
];
