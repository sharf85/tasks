import {Injectable} from '@angular/core';
import {Hero} from '../model/hero';
import {HEROES} from '../mock-heroes';
import {Observable, of} from 'rxjs';
import {delay} from 'rxjs/operators';
import {MessageStorage} from './message.storage';

@Injectable()
export class HeroService {

  constructor(private messageStorage: MessageStorage) {
  }

  getHeroes(): Observable<Hero[]> {
    this.messageStorage.add('HeroService: fetched heroes');
    return of(HEROES).pipe(delay(1000));
  }

  getHero(id: number): Observable<Hero> {
    this.messageStorage.add(`HeroService: fetched hero id=${id}`);
    return of(HEROES.find(value => value.id === id));
  }
}
