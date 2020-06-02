import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ContactService {
  private host = 'http://localhost:8090/';

  contacts: Observable<Contact[]>;

  constructor(private httpClient: HttpClient) {
  }

  add(contact: Contact): void {
    this.httpClient.post(`${this.host}contact`, contact)
      .subscribe(value => this.reloadContacts());
  }

  private reloadContacts() {
    this.contacts = this.httpClient.get<Contact[]>(`${this.host}contact`);
  }

  getAll(): Observable<Contact[]> {
    if (!this.contacts) {
      this.reloadContacts();
    }
    return this.contacts;
  }

  edit(contact: Contact): void {
    this.httpClient.put<void>(`${this.host}contact`, contact)
      .subscribe(value => this.reloadContacts());
  }

  remove(contact: Contact) {
    this.httpClient.delete<void>(`${this.host}contact/${contact.id}`)
      .subscribe(value => this.reloadContacts());
  }
}
