import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UserService {
  private REST_URL = "";
  private endpoints = {
    tokenReq: this.REST_URL + "api/user/auth"
    //Call them whatever, easier to have them grouped
  }

}
