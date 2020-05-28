import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';
import {ContactEventService} from '../service/contact-event.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit
  // , OnDestroy
{

  @Input()
  childContact: Contact;

  constructor(private contactService: ContactService,
              private contactEventService: ContactEventService) {
  }

  // subs: Subscription;
  //
  ngOnInit(): void {
    //   this.subs = this.contactEventService.subscribeEditContact((_) => console.log('on edit contact'));
  }

  // ngOnDestroy(): void {
  //   this.subs.unsubscribe();
  // }

  onClickDelete() {
    this.contactService.remove(this.childContact);
  }

  onClickEdit() {
    this.contactEventService.emitEditContact(this.childContact);
  }


}
