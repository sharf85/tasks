import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/Contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {
  contacts: Contact[] = [];

  constructor(private contactService: ContactService) {
  }

  ngOnInit(): void {
    this.contactService.getContacts().subscribe(contacts => this.contacts = contacts);
  }

  onDelete(contact: Contact): void {
    this.contactService.deleteContact(contact.id).subscribe(
      _ => this.contacts = this.contacts.filter(value => {
        return value.id !== contact.id;
      })
    );
  }
}
