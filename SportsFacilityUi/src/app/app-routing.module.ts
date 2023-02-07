import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {HomeComponent} from "./components/home/home.component";
import {AuthGuard} from "./auth/auth.guard";
import {UpdatePlayerComponent} from "./components/update-player/update-player.component";
import {BookFacilityComponent} from "./components/book-facility/book-facility.component";


const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "home", component: HomeComponent, canActivate: [AuthGuard]},
  {path: "update", component: UpdatePlayerComponent, canActivate: [AuthGuard]},
  {path: "getSlots", component: BookFacilityComponent, canActivate: [AuthGuard]},
  {path: "**", redirectTo: 'login', pathMatch: "full"},
  {path: "", redirectTo: 'login', pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
