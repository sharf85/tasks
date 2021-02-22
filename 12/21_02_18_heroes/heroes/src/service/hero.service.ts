import {Injectable} from '@angular/core';
import {Hero} from '../model/hero';
import {HEROES} from '../app/mock-heroes';
import {Observable, of} from 'rxjs';
import {delay} from 'rxjs/operators';
import {MessageService} from './message.service';

@Injectable()
export class HeroService {

  constructor(private messageService: MessageService) {
  }

  getHeroes(): Observable<Hero[]> {
    this.messageService.add('HeroService: fetched heroes');
    return of(HEROES).pipe(delay(1000));
  }
}
