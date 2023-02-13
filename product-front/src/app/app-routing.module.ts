import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './components/catalogue/catalogue.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes =  [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'products', component: CatalogueComponent},
  {path: 'home', component: HomeComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
