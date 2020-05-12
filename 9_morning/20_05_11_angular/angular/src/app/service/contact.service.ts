import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';

@Injectable()
export class ContactService {

  static currentId = 0;
  private readonly contacts: Contact[];

  constructor() {
    this.contacts = [];
  }

  add(contact: Contact): void {
    contact.id = ++ContactService.currentId;
    this.contacts.push(contact);
  }

  getAll(): Contact[] {
    console.log(this.contacts);
    return this.contacts;
  }
}
