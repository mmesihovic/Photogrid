import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  public isAuthenticated(): boolean {    
    const token = localStorage.getItem('token');    // Check whether the token is expired and return

    return token != null;
  }
}
