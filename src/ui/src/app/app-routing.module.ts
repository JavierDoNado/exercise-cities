import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CitiesPage } from './cities-page/cities.component';

const routes: Routes = [
  {path : 'cities', component: CitiesPage}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
