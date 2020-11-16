import {Component, OnInit} from '@angular/core';
import {Hero} from '../model/hero';
import {HeroService} from '../service/hero.service';
import {Observable} from 'rxjs';
import {MessageStorage} from '../service/message.storage';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css'],
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];

  constructor(private heroService: HeroService, public messageStorage: MessageStorage) {
  }

  ngOnInit(): void {
    const futureHeroes: Observable<Hero[]> = this.heroService.getHeroes();
    futureHeroes.subscribe(value => this.heroes = value);
  }
}
