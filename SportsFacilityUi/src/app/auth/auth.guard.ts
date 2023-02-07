import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthService} from "../services/auth.service";
import {map, catchError, of, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthService, private route: Router) {
  }

  id: string = ''

  canActivate(): Observable<boolean> {
    return this.checkValid();
  }

  checkValid() {
    return this.auth.validateToken().pipe(
      map((value) => {
          if (value != null) {
            this.id = value.id
            return value.valid;
          }
        }
      ),
      catchError(err => {
        this.route.navigate(['login'])
        return of(false)
      }))
  }
}
