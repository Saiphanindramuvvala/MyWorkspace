import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validator, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public error: boolean = false;
  public errorMsg: string = '';

  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.email],),
    password: new FormControl('', [Validators.required, Validators.minLength(8)])
  })

  constructor(private authService: AuthService, private route: Router) {
  }

  isLoggedin: boolean= false;

  ngOnInit(): void {
  }

  onSubmit() {
    const {username, password} = this.loginForm.value
    // @ts-ignore
    this.authService.login(username, password).subscribe({
      next: res => {
        localStorage.setItem('token', res.token)
        this.route.navigate(['home'])
        this.isLoggedin= true
      },
      error: err => {
        console.log(err)
        this.error = true
        const {error} = err.error
        this.errorMsg = error ? error : 'UNKNOWN ERROR!'
        setTimeout(args => {
          this.error = false
        }, 6000)
      }
    })
  }
  logout() {
    localStorage.removeItem('token');
    this.isLoggedin = false;
    this.route.navigate(['login'])
  }
  isLoggedIn() {
    debugger;
    if (localStorage.getItem("token") == null) {
      this.isLoggedin = false;
      return this.isLoggedin;
    }
    else {
      return true;
    }
  }
}
