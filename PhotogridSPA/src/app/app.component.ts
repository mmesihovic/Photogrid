import { Component } from '@angular/core';
import { UserService } from './services/user.service';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private userService: UserService) {}  

  title = 'photogrid';
  user : User = null;

  get isAuthenticated() {
    return this.userService.isAuthenticated();
  }

  userLoggedIn(user: User) {
    console.log(user);
  }
}
