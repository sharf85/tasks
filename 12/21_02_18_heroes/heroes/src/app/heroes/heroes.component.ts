import {Component, OnInit} from '@angular/core';
import {Hero} from '../../model/hero';
import {HeroService} from '../../service/hero.service';
import {Observable} from 'rxjs';
import {MessageService} from '../../service/message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];

  selectedHero: Hero;

  // private heroService: HeroService;
  //
  // constructor(heroService: HeroService) {
  //   this.heroService = heroService;
  // }

  // the same
  constructor(private heroService: HeroService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    const observableHeroes: Observable<Hero[]> = this.heroService.getHeroes();
    observableHeroes.subscribe(value => this.heroes = value);
  }

  onClickHero(hero: Hero): void {
    this.selectedHero = hero;
    this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
  }

  isSelected(hero: Hero): boolean {
    return this.selectedHero === hero;
  }
}
