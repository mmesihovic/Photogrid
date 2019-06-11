import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { mergeMap } from 'rxjs/operators';
import { LoginResponse } from '../models/login-response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public isAuthenticated(): boolean {    
    const token = localStorage.getItem('token');   

    return token != null;
  }

  public login(username: string, password: string) : Observable<User> {
    return this.http.post<LoginResponse>(
      "http://localhost:8762/api/users/auth",
      {
        username: username,
        password: password
      }
    ).pipe(
      mergeMap(ur => {
        localStorage["token"] = ur.token;
        localStorage["token_expiration"] = ur.expires_in;
        return this.http.get<User>("http://localhost:8762/api/users/users/username/" + ur.username);
      }
      )
    );
  }

  public getToken() : String {
    return localStorage["token"];
  }
}
