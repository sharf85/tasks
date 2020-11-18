import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Person} from '../../model/person';
import {PersonService} from '../../service/person.service';
import {EventService} from '../../service/event.service';

@Component({
  selector: 'app-person-item',
  templateUrl: './person-item.component.html',
  styleUrls: ['./person-item.component.css']
})
export class PersonItemComponent implements OnInit {

  @Output()
  personDeleted = new EventEmitter<Person>();

  @Input()
  person: Person;

  constructor(private personService: PersonService, private eventService: EventService) {
  }

  ngOnInit(): void {
  }

  onDeletePerson(): void {
    const callback = removedPerson => this.personDeleted.emit(removedPerson);

    this.personService.remove(this.person)
      .subscribe(callback);
  }

  onEditPerson(): void {
    this.eventService.addPersonToEdit(this.person);
  }


}
