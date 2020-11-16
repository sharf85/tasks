import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PersonsComponent} from './app/persons/persons.component';

const routes: Routes = [
  {path: 'persons', component: PersonsComponent},
  {path: '', redirectTo: '/persons', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
