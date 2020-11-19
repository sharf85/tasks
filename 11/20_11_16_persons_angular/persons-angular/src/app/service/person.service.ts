import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {Person} from '../model/person';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private httpClient: HttpClient) {
  }

  private readonly PERSONS_URI = '/api/persons';

  getAll(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.PERSONS_URI);
  }

  add(person: Person): Observable<Person> {
    return this.httpClient.post<Person>(this.PERSONS_URI, person);
  }

  edit(person: Person): Observable<void> {
    return this.httpClient.put<void>(`${this.PERSONS_URI}/${person.id}`, person);
  }

  remove(person: Person): Observable<Person> {
    return this.httpClient.delete<Person>(`${this.PERSONS_URI}/${person.id}`);
  }

  get(id: number): Observable<Person> {
    return this.httpClient.get<Person>(`${this.PERSONS_URI}/${id}`);
  }
}
