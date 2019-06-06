import { Component } from '@angular/core';

@Component({
  selector: 'user-details-component',
  templateUrl: './user-details.component.html',
})

export class UserDetailsComponent {
    userName = 'mmesihovic';
    noPosts = 10;
    noFollowers = 43;
    noFollowing = 23;
    fullName = 'Mirza Mesihovic';
    desc = 'Lorem ipsum mrsko mi je.';
    fbLink = 'facebook.com/mesoha';
    isEdit = false;
}
