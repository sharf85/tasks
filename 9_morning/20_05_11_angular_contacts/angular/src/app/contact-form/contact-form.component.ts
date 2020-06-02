import {Component, OnDestroy, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';
import {ContactEventService} from '../service/contact-event.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit, OnDestroy {

  contact: Contact;

  isAddingState: boolean;
  editContactSubs: Subscription;

  constructor(private contactService: ContactService,
              private contactEventService: ContactEventService) {
  }

  ngOnInit(): void {
    this.clearForm();
    this.editContactSubs = this.contactEventService.subscribeEditContact((value) => this.onEditContact(value));
  }

  ngOnDestroy(): void {
    this.editContactSubs.unsubscribe();
  }

  onEditContact(value: Contact) {
    Object.assign(this.contact, value);
    this.isAddingState = false;
  }

  onClickAdd() {
    console.log(this.contact);
    this.contactService.add(this.contact);
    this.clearForm();
  }

  clearForm() {
    this.contact = new Contact();
    this.isAddingState = true;
  }

  onClickEdit() {
    this.contactService.edit(this.contact);
    this.clearForm();
  }

  onClickCancel() {
    this.clearForm();
  }
}
