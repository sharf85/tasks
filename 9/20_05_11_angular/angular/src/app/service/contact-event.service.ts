import {EventEmitter, Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Subscription} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactEventService {

  private editContact: EventEmitter<Contact> = new EventEmitter<Contact>();

  constructor() {
  }

  emitEditContact(contact: Contact) {
    this.editContact.emit(contact);
  }

  subscribeEditContact(callback): Subscription {
    return this.editContact.subscribe(callback);
  }
}
