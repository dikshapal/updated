import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
export class CurrentStatus{

  constructor(
    public AccountId:String,
    public AmountSanction: String,
    public AmountRemaining: String
  ){

  }
}

@Injectable({
  providedIn: 'root'
})


export class HttpClientService {

  constructor(
    private http:HttpClient
  ) { }

  getCurrentStatus(){
    console.log("test call");
  return  this.http.get<CurrentStatus[]>('http://localhost:8080/getstatus');
  }

}
