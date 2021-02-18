import {Component, OnInit} from '@angular/core';
import {Hero} from '../../model/hero';
import {HEROES} from '../mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];

  selectedHero: Hero;

  constructor() {

  }

  ngOnInit(): void {
    this.heroes = HEROES;
  }

  onClickHero(hero: Hero): void {
    this.selectedHero = hero;
  }

  isSelected(hero: Hero): boolean {
    return this.selectedHero === hero;
  }
}
