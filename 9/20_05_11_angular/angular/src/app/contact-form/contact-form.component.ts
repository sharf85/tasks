import {Component, Input, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  // tslint:disable-next-line:variable-name
  private _contact: Contact;

  get contact() {
    return this._contact;
  }

  @Input()
  set contact(value: Contact) {
    console.log('here');
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
    this._contact = new Contact();
  }

  onClickAdd(): void {
    this.contactService.add(this.contact);
    this.clearForm();
  }

  onClickEdit(): void {
    this.contactService.edit(this.contact);
    this.clearForm();
    this.isAddingState = true;
  }

  clearForm(): void {
    this._contact = new Contact();
  }
}
