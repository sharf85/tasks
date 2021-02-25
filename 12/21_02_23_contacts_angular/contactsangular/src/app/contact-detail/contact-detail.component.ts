import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/Contact';
import {ContactService} from '../service/contact.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.css']
})
export class ContactDetailComponent implements OnInit {
  contact: Contact;

  constructor(private contactService: ContactService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.contactService.getContact(id).subscribe(contact => this.contact = contact);
  }

}
