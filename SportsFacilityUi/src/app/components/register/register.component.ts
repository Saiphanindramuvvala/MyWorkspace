import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {RegistrationService} from "../../services/registration.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public success: boolean = false;
  public error: boolean = false;
  public errorMsg: string = '';
  public successMsg: string = '';

  constructor(private regService: RegistrationService, private route: Router) {
  }

  registerForm = new FormGroup({
      fname: new FormControl('', [Validators.required, Validators.pattern('^$|[A-Za-z]')]),
      lname: new FormControl('', [Validators.required, Validators.pattern('^$|[A-Za-z]')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      dob: new FormControl('', [Validators.required]),
      mobile: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern('^$|[0-9]{10}')]),
      address: new FormControl('', Validators.required),
      state: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      pan: new FormControl('', [Validators.required, Validators.minLength(12), Validators.pattern('$|[a-zA-Z0-9]{12}')]),
      password: new FormControl('', [Validators.required, Validators.minLength(8)]),
      cpassword: new FormControl('', [Validators.required, Validators.minLength(8)])
    },
    [this.MatchValidator('password', 'cpassword')])

  ngOnInit(): void {
  }

  onSubmit() {
    const {fname, lname, email, dob, mobile, address, state, country, pan, password} = this.registerForm.value
    // @ts-ignore
    this.regService.register(fname, lname, email, dob, mobile, address, state, country, pan, password).subscribe({
      next: res => {
        this.success = true
        this.successMsg = 'Player Registered successfully!'
        setTimeout(args => {
          this.success = false
        }, 5000)
        this.route.navigate(['login'])
      },
      error: err => {
        this.error = true
        const {error} = err.error
        this.errorMsg = error ? error : 'UNKNOWN ERROR!';
        setTimeout(args => {
          this.error = false
        }, 6000)
      }
    })
  }

  MatchValidator(password: string, cpassword: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      let pswrd = control.get(password);
      let cpswrd = control.get(cpassword);
      return pswrd && cpswrd && pswrd.value !== cpswrd.value ? {mismatch: true} : null;
    };
  }
}
