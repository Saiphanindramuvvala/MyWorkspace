import {Component, OnInit} from '@angular/core';
import {BookFacilityService} from "../../services/book-facility.service";
import {AuthGuard} from '../../auth/auth.guard'
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {UpdateserviceService} from '../../services/updateservice.service'
import {Router} from "@angular/router";

@Component({
  selector: 'app-book-facility',
  templateUrl: './book-facility.component.html',
  styleUrls: ['./book-facility.component.css']
})
export class BookFacilityComponent implements OnInit {

  constructor(private service: BookFacilityService, private route: Router, private authG: AuthGuard, private bookService: BookFacilityService, private updateService: UpdateserviceService) {
    this.progress = true
    this.service.getAvailableSlots().subscribe({
      next: value => {
        this.progress = false
        this.availableSlots = value
        console.log(value)
      },
      error: err => {
        this.progress = false
        console.log(err)
      }
    })
    this.updateService.getPlayerDetails(this.authG.id).subscribe({
      next: data => {
        this.player.playerId = data.id
        this.player.dob = data.dob
        this.player.first_name = data.fname
        this.player.last_name = data.lname
        this.bookingForm.patchValue({
          fname: data.fname,
          lname: data.lname,
          dob: data.dob,
          id: data.id
        })
      },
      error: err => {
        console.log(err)
      }
    })
  }

  checkSlotForm: boolean = false
  gameName = ''
  minDate = new Date().toISOString().split('T')[0]
  progress: boolean = false
  error: boolean = false;
  errorMsg: string = '';
  success: boolean = false;

  dateValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    let valueDate = new Date(control.value).getDate()
    let todayDate = new Date().getDate()
    return valueDate >= todayDate ? null : {mismatch: true}
  }
  bookingForm = new FormGroup({
    id: new FormControl({value: "", disabled: true}, [Validators.required]),
    fname: new FormControl({value: "", disabled: true}, [Validators.required, Validators.pattern('^$|[A-Za-z]')]),
    lname: new FormControl({value: "", disabled: true}, [Validators.required, Validators.pattern('^$|[A-Za-z]')]),
    dob: new FormControl({value: "", disabled: true}, [Validators.required]),
    gameName: new FormControl({value: "", disabled: true}, [Validators.required, Validators.pattern('^$|[A-Za-z]')]),
    dateOfGame: new FormControl('', [Validators.required, this.dateValidator]),
    timeOfGame: new FormControl('', [Validators.required, timeValidator]),
  })

  player = {
    playerId: '',
    first_name: '',
    dob: '',
    last_name: '',
    gameName: ''
  }
  booking = {
    bookingId: '',
    gameName: '',
    playerId: '',
    groundNumber: '',
    dateOfGame: '',
    timeOfGame: ''
  }
  availableSlots = [{
    gameName: "",
    totalGround: '',
    available: false
  }]

  ngOnInit(): void {
  }

  checkSlot(gameName: string) {
    this.checkSlotForm = !this.checkSlotForm
    this.player.gameName = gameName
    this.bookingForm.patchValue({
      gameName: gameName
    })
  }

  onSubmit() {
    let booking = {...this.player, ...this.bookingForm.value}
    console.log(booking)
    this.bookService.bookASlot(booking).subscribe({
      next: res => {
        this.success = true
        this.booking.bookingId = res.bookingId
        this.booking.playerId = res.playerId
        this.booking.gameName = res.gameName
        this.booking.groundNumber = res.groundNumber
        this.booking.dateOfGame = res.dateOfGame
        this.booking.timeOfGame = res.timeOfGame
      },
      error: err => {
        this.error = true
        const{error} = err.error
        this.errorMsg = error?error:"Unexpected Error"
        console.log(err.error.response)
      }
    })
  }

}


const timeValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  let valueTime = control.value
  let startingTime = '06:00'
  let endingTime = '22:00'
  console.log(valueTime > startingTime && valueTime < endingTime)
  return valueTime > startingTime && valueTime < endingTime ? null : {mismatch: true}
}
