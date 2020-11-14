import {Component, OnInit} from '@angular/core';
import {MessageStorage} from '../service/message.storage';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(public messageStorage: MessageStorage) {
  }

  ngOnInit(): void {
  }

}
