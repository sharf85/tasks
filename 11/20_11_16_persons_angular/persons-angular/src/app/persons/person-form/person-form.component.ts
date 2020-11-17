import {Component, OnInit, Output} from '@angular/core';
import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {EventEmitter} from '@angular/core';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

  @Output()
  personCreated = new EventEmitter<Person>();

  person: Person = {};

  isEdit = false;

  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
  }

  onAdd(): void {
    this.personService.add(this.person)
      .subscribe(newPerson => {
        this.personCreated.emit(newPerson);
        this.person = {};
      });
  }
}
