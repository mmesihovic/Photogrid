import { Injectable } from '@angular/core';

@Injectable({
  providedIn : 'root'
})
export class UserService {
  private REST_URL = "http://localhost:8762/";
  private endpoints = {
    tokenReq: this.REST_URL + "api/user/auth"
    //Call them whatever, easier to have them grouped
  }

  login(username : string, password : string) {
    console.log("Servis nesto radi.");
  }

}
