import { AuthService } from './../services/auth.service';

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

 

  constructor(private router: Router) { }

  fandv(): void {
    this.router.navigateByUrl("/fruitsandveggies");
}
}