import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Photogrid';
  currentUser : User;

  constructor(
    private router : Router
  ) {
    this.currentUser;
  };

  ngOnInit() {
    /*if(this.currentUser == null) {
      this.router.navigate(['/login']);
    }*/
  }
}
