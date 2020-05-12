import {Component} from '@angular/core';
import {ContactService} from './service/contact.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ContactService]
})
export class AppComponent {
  title = 'Contacts';

  constructor(public contactService: ContactService) {
  }
}
