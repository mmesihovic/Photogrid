import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'navbar-component',
  templateUrl: './navbar.component.html',
})

export class NavbarComponent {
  title = 'Photogrid';

  constructor(
    private router: Router
  ) {

  }
}
