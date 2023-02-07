import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

const BOOK_API = 'http://localhost:8082/'
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class BookFacilityService {


  constructor(private http: HttpClient) {
  }

  getAvailableSlots(): Observable<any> {
    const tk = localStorage.getItem('token')
    return this.http.get(BOOK_API + 'availableSlots', {
      headers: new HttpHeaders({'Authorization': 'Bearer ' + tk})
    })
  }

  bookASlot(booking: any): Observable<any> {
    const tk = localStorage.getItem('token')
    return this.http.post(BOOK_API + 'book', {...booking}, {
      headers: new HttpHeaders({'Authorization': 'Bearer ' + tk})
    })
  }

}
