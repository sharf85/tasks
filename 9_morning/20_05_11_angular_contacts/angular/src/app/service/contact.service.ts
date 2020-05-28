import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Observable, of} from 'rxjs';
import {CONTACTS} from './contacts-mock';

@Injectable()
export class ContactService {

  constructor() {
  }

  add(contact: Contact): void {
    contact.id = CONTACTS.length + 1;
    CONTACTS.push(contact);
  }

  getAll(): Observable<Contact[]> {
    return of(CONTACTS);
  }

  edit(contact: Contact) {
    const contactToEdit = CONTACTS.find(value => value.id === contact.id);
    Object.assign(contactToEdit, contact);
  }
}
