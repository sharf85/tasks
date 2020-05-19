import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact: Contact;

  isAddingState: boolean;
  private contactService: ContactService;

  constructor(contactService: ContactService) {
    this.contactService = contactService;
  }

  ngOnInit(): void {
    this.isAddingState = true;
    this.contact = new Contact();
  }

  onClickAdd() {
    console.log(this.contact);
    this.contactService.add(this.contact);
    this.clearForm();
  }

  clearForm() {
    this.contact = new Contact();
  }
}
