import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import{NavigationComponent} from './navigation/navigation.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import{AdminComponent}from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes = [
  {path:'signup', component: SignupComponent},
  {path:'login', component: LoginComponent},
  {path: '/', component: WelcomeComponent},
  {path:'signin',component:AdminComponent},
  {path:'navigation',component:NavigationComponent},
  {path:'home',component:HomeComponent},
  {path:'admin',component:AdminComponent},
  {path:'cart',component:CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }