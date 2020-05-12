import {Component, Input, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from "../service/contact.service";

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  _contact: Contact;

  get contact() {
    return this._contact;
  }

  @Input()
  set contact(value: Contact) {
    if (value) {
      this.isAddingState = false;
      this._contact = value;
    }
  }

  isAddingState: boolean;

  constructor(private contactService: ContactService) {
  }

  ngOnInit(): void {
    this.isAddingState = true;
    this.contact = new Contact();
  }

  onClickAdd() {
    this.contactService.add(this.contact);
  }
}
