import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PostComponent } from './components/post/post.component';
import { NewPostComponent } from './components/newPost/newPost.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [
  { path: '', component: DashboardComponent, canActivate: [AuthGuardService] },
  {path: 'login', component : LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuardService]},
  {path: 'newPost', component: NewPostComponent, canActivate: [AuthGuardService]},
  {path: ':username', component: ProfileComponent, canActivate: [AuthGuardService]},
  {path: 'post/:id', component: PostComponent, canActivate: [AuthGuardService]},
  { path: '**', redirectTo: '' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
