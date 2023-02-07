import {Component, OnInit} from '@angular/core';
import {AuthGuard} from '../../auth/auth.guard'
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {UpdateserviceService} from '../../services/updateservice.service'
import {Router} from "@angular/router";

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent implements OnInit {

  progress: boolean = false

  constructor(private authG: AuthGuard, private service: UpdateserviceService, private route: Router) {
    this.progress = true
    this.service.getPlayerDetails(this.authG.id).subscribe({
      next: (data) => {
        console.log(data)
        this.progress = false
        this.playerId = data.id
        this.updateForm.patchValue({
          email: data.email,
          mobile: data.mobile,
          address: data.address,
          pan: data.pan,
          state: data.state
        })
      },
      error: (err) => {
        this.route.navigate(['home'])
      }
    })
  }

  public success: boolean = false;
  public error: boolean = false;
  playerId: string = ""

  updateForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    mobile: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern('^$|[0-9]{10}')]),
    address: new FormControl('', Validators.required),
    pan: new FormControl('', [Validators.required, Validators.minLength(12), Validators.pattern('$|[a-zA-Z0-9]{12}')]),
    state: new FormControl('', Validators.required)
  })

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.updateForm.value)
    this.progress = true
    this.service.updatePlayerDetails(this.playerId, this.updateForm.value).subscribe({
      next: data => {
        this.progress = false
        setTimeout(args => {
          this.success = true
        }, 3000)
        console.log(data)
      },
      error: err => {
        this.progress = false
        setTimeout(args => {
          this.error = false
        }, 3000)
        console.log(err)
      }
    })
  }
}
