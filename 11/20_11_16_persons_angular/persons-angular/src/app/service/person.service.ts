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

  //
  // edit(person: Person): Observable<void> {
  //
  // }
  //
  // remove(person: Person): Observable<void> {
  //
  // }
  //
  // get(id: number): Observable<Person> {
  //
  // }
}
