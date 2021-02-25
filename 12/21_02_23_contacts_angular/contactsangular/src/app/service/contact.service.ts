import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Contact} from '../model/Contact';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private contactsApi = 'api/contacts';

  constructor(private http: HttpClient) {
  }

  addContact(contact: Contact): Observable<Contact> {
    return this.http.post<Contact>(this.contactsApi, contact);
  }

  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(this.contactsApi);
  }

  getContact(id: number): Observable<Contact> {
    return this.http.get<Contact>(`${this.contactsApi}/${id}`);
  }

  deleteContact(id: number): Observable<Contact> {
    return this.http.delete<Contact>(`${this.contactsApi}/${id}`);
  }

  editContact(contact: Contact): Observable<void> {
    return this.http.put<void>(this.contactsApi, contact);
  }
}
