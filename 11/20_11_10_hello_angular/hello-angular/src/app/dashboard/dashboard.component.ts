import {Component, OnInit} from '@angular/core';
import {Hero} from '../model/hero';
import {HeroService} from '../service/hero.service';
import {observable, Observable} from 'rxjs';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  heroes: Hero[];

  constructor(private heroService: HeroService) {
  }

  ngOnInit(): void {
    const futureHeroes: Observable<Hero[]> = this.heroService.getHeroes();
    futureHeroes.subscribe(value => this.heroes = value.slice(0, 4));
  }

}
