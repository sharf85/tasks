import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ContactsComponent} from './contacts/contacts.component';
import {ContactDetailComponent} from './contact-detail/contact-detail.component';
import {AddContactComponent} from './add-contact/add-contact.component';
import {EditContactComponent} from './edit-contact/edit-contact.component';

const routes: Routes = [
  {path: '', redirectTo: '/contacts', pathMatch: 'full'},
  {path: 'contacts', component: ContactsComponent},
  {path: 'contact/add', component: AddContactComponent},
  {path: 'contact/:id', component: ContactDetailComponent},
  {path: 'contact/:id/edit', component: EditContactComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
