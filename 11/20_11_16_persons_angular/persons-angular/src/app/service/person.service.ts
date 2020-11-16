import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Person} from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor() {
  }

  getAll(): Observable<Person> {

  }

  add(person: Person): Observable<Person> {

  }

  edit(person: Person): Observable<void> {

  }

  remove(person: Person): Observable<void> {

  }

  get(id: number): Observable<Person> {

  }
}
