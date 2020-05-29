import {Component, OnInit} from '@angular/core';
import {ContactService} from './service/contact.service';
import {Contact} from './model/contact';
import {Observable} from 'rxjs';

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
    this.contactToEdit = $event;
  }

}
