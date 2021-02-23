import {Component, OnInit} from '@angular/core';
import {ContactService} from '../service/contact.service';
import {Contact} from '../model/Contact';
import {Router} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  contact: Contact = {};

  constructor(private contactService: ContactService,
              private router: Router,
              private location: Location) {
  }

  ngOnInit(): void {
  }

  onSave(): void {
    this.contactService.addContact(this.contact).subscribe(_ => this.router.navigate(['']));
  }

  onCancel(): void {
    this.location.back();
  }
}
