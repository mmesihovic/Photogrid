import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'registration-component',
  templateUrl: './registration.component.html',
})

export class RegistrationComponent {

  constructor(
    private router : Router
  ) {

  }

}
