import {Component, Input, OnInit} from '@angular/core';
import {Hero} from '../../model/hero';
import {HeroService} from '../../service/hero.service';
import {Location} from '@angular/common';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  @Input()
  hero: Hero;

  constructor(private heroService: HeroService,
              private location: Location,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.heroService.getHero(id)
      .subscribe(value => this.hero = value);
  }

  onBack(): void {
    this.location.back();
  }
}
