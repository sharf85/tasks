import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact: Contact;
  isAddingState: boolean;

  constructor() {
  }

  ngOnInit(): void {
    this.isAddingState = true;
    this.contact = new Contact();
  }

  onAdd() {
    console.log(this.contact);
  }
}
