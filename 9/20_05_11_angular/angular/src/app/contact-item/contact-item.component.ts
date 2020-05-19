import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit {

  @Input()
  childContact: Contact;

  @Output()
  edit: EventEmitter<Contact> = new EventEmitter<Contact>();

  constructor(private contactService: ContactService) {
  }

  ngOnInit(): void {
  }

  onClickDelete() {
    this.contactService.remove(this.childContact);
  }

  onClickEdit() {
    this.edit.emit(Object.assign({}, this.childContact));
  }
}
