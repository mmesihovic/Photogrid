import { Component, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
})

export class LoginComponent {

  loginForm : FormGroup;

  @Output() loggedIn: EventEmitter<User> = new EventEmitter<User>();

  constructor(
    private fb : FormBuilder,
    private userService : UserService,
    private router: Router
  ) {
    this.createForm();
  }

  private createForm() {
    this.loginForm = this.fb.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.compose([Validators.required])]
    });
  }

  login() {
    
    if(!this.loginForm.valid)
      return;
      this.userService.login(this.loginForm.get('username').value, this.loginForm.get('password').value)
        .subscribe(u => {
         this.loggedIn.emit(u);
        });
  }
}
