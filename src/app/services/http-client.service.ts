import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Router } from '@angular/router';

import { SignupComponent } from 'app/signup/signup.component';

import { LoginComponent } from 'app/login/login.component';





export class Submit{
constructor(
public firstname :String, 
public lastname:String,
public email: String,
public password:String,
public number:number){}
}

export class SignIn{
    constructor(
        public email :String,
        public password:String
    ){}
}


@Injectable()

export class HttpClientService {

 constructor(private httpClient:HttpClient , private router : Router){ }




registeruser(signup)

{
console.log("test call");
return this.httpClient.post<Submit>("http://localhost:8080/register",signup)
.subscribe(data=>{
console.log(data)
   })
}

public signinuser(signin)

{
return this.httpClient.post<SignIn>("http://localhost:8080/login",signin);

}



}