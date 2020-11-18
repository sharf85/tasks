import {EventEmitter, Injectable} from '@angular/core';
import {Person} from '../model/person';
import {Subscription} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private personToEdit = new EventEmitter<Person>();

  constructor() {
  }

  addPersonToEdit(person: Person): void {
    this.personToEdit.emit(person);
  }

  subscribeOnPersonToEdit(callback): Subscription {
    return this.personToEdit.subscribe(callback);
  }
}
