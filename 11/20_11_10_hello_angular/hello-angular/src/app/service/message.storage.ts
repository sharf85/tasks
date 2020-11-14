import {Injectable} from '@angular/core';

@Injectable()
export class MessageStorage {

  messages: string[] = [];

  add(message: string): void {
    this.messages.push(message);
  }

  clear(): void {
    this.messages = [];
  }

  get(index: any): string {
    return this.messages[index];
  }

  size(): number {
    return this.messages.length;
  }

}
