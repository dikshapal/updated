import { Component, OnInit } from '@angular/core';
import {HttpClientService} from '../service/http-client.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-current-status',
  templateUrl: './current-status.component.html',
  styleUrls: ['./current-status.component.css']
})
export class CurrentStatusComponent implements OnInit {

  currentStatus:String[];
  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getCurrentStatus().subscribe(
      response =>{
        console.log(response);
        this.handleSuccessfulResponse(response)}
     );

  }

  handleSuccessfulResponse(response){
    this.currentStatus=response;
  }
}
