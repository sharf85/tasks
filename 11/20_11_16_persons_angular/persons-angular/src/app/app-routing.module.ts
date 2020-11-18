import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PersonsComponent} from './persons/persons.component';

const routes: Routes = [
  // TODO
  // 1. add a new component showing PersonDetails
  // 2. add a new route corresponding to this component
  {path: 'persons', component: PersonsComponent},
  {path: '', redirectTo: '/persons', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
