import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CurrentStatusComponent} from './current-status/current-status.component';


const routes: Routes = [
  { path:'', component:CurrentStatusComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
