import {Component, OnInit} from '@angular/core';
import {Person} from '../model/person';
import {PersonService} from '../service/person.service';
import {Observable} from 'rxjs';
import {addWarning} from '@angular-devkit/build-angular/src/utils/webpack-diagnostics';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {

  persons: Person[] = [];

  constructor(private personService: PersonService) {
  }

  async ngOnInit(): Promise<void> {
    this.persons = await this.getPersons();
  }

  async getPersons(): Promise<Person[]> {
    return await this.personService.getAll().toPromise();
  }

}
