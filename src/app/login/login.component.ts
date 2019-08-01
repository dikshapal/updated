
import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { HttpClientService, SignIn } from 'app/services/http-client.service';
import {JwtHelper,tokenNotExpired} from 'angular2-jwt';
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  signin:SignIn=new SignIn("","");
  
  static flag:boolean=false;
  
  
  
  constructor(private httpClientService:HttpClientService, private router: Router) { }
  
  
  
  ngOnInit() {
  
  }
  
  
  
  // onSumbit()
  
  // {
  
  // this.loginUser(); 
  
  // }
  
  
  
  
  signinuser(): void {
  
  console.log(this.signin);
  
  this.httpClientService.signinuser(this.signin)
  
  .subscribe(data => {
  
  console.log(data);
  
  
  
  if(!data)
  
  {
  
  alert("try again");
  
  }
  
  else{
  
  LoginComponent.flag=true;
  
  this.router.navigateByUrl('/home');
  
  console.log("hi");
  // this.router.navigateByUrl('register') ;
  
  }
  
  
  })
  
  }
  
  
  ValidateUser(): boolean{
  return LoginComponent.flag;
  
  }
  
  
  
   //RegisterUser(): void {
  
   //this.router.navigateByUrl('register') 
  
  
  
  //}
}