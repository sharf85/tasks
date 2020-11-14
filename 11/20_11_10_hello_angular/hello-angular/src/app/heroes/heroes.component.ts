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

  selectedHero: Hero;

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
    this.messageStorage.add(`HeroesComponent: Selected hero id=${hero.id}`);
  }

  constructor(private heroService: HeroService, public messageStorage: MessageStorage) {
  }

  ngOnInit(): void {
    const futureHeroes: Observable<Hero[]> = this.heroService.getHeroes();
    futureHeroes.subscribe(value => this.heroes = value);
  }
}
