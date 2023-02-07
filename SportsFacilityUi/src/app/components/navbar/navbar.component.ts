import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [LoginComponent, AuthService]
})
export class NavbarComponent implements OnInit {

  constructor(public logStat: LoginComponent) { }
  isAuthenticated: boolean= false;

  ngOnInit(): void {
  }

  Logout() {
    this.logStat.logout();
  }

  isLoggedIn() {
    this.isAuthenticated = this.logStat.isLoggedIn();
  }

}
