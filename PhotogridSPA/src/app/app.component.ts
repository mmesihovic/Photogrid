import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { UserService } from './services/user.service';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent /*implements OnInit*/ {
  title = 'Photogrid';
  currentUser : User;

  /*constructor(
    //private userService : UserService,
    private router : Router
  ) {
    this.currentUser = null;
  };

  ngOnInit() {
    if(this.currentUser == null) {
      this.router.navigate(['/login']);
    }
  }*/
}
