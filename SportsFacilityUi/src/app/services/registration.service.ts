import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

const AUTH_API = 'http://localhost:8081/player'
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {


  constructor(private http: HttpClient) {
  }

  register(fname: string, lname: string,
           email: string, dob: string,
           mobile: string, address: string,
           state: string, country: string,
           pan: string,
           password: string): Observable<any> {
    console.log(fname, lname, email, dob, mobile, address, state, country, pan, password)
    return this.http.post(
      AUTH_API + '/register',
      {
        fname, lname, email, dob, mobile, address, state, country, pan, password,age:19
      },
      httpOptions
    );
  }
}
