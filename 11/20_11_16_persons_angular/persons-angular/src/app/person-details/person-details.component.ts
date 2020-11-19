import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PersonService} from '../service/person.service';
import {Person} from '../model/person';
import {Location} from '@angular/common';

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  person: Person;

  constructor(
    private route: ActivatedRoute,
    private personService: PersonService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.personService.get(id).subscribe(value => this.person = value);
  }

  goBack(): void {
    this.location.back();
  }

}
