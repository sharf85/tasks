import {Component} from '@angular/core';
import {ContactService} from './service/contact.service';
import {Contact} from "./model/contact";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ContactService]
})
export class AppComponent {

  constructor(public contactService: ContactService) {
  }

  contactToEdit: Contact;

  title = 'Contacts';

  onEditContact($event: Contact) {
    console.log($event);
    this.contactToEdit = $event;
  }
}
