import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {JwtHelperService} from "@auth0/angular-jwt";
import {loadSecondaryEntryPointInfoForApfV14} from "@angular/compiler-cli/ngcc/src/utils";

const AUTH_API = 'http://localhost:8081/player'
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string): Observable<any> {
    console.log(username, password)
    return this.http.post(
      AUTH_API + '/login',
      {
        username,
        password
      },
      httpOptions
    )
  }
  validateToken():Observable<any>{
    const tk = localStorage.getItem('token')
    return this.http.get(AUTH_API + '/validatetoken',{
      headers: new HttpHeaders({'Authorization': 'Bearer '+ tk})
    })
  }
}
