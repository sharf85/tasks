import {Component, OnInit} from '@angular/core';
import {Hero} from '../../model/hero';
import {HeroService} from '../../service/hero.service';

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
    this.heroService.getHeroes()
      .subscribe(value => this.heroes = value.slice(0, 4));
  }

}
