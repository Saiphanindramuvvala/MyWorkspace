import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

const UPDATE_API = 'http://localhost:8083/player'

@Injectable({
  providedIn: 'root'
})
export class UpdateserviceService {

  constructor(private http: HttpClient) {
  }

  getPlayerDetails(id: string): Observable<any> {
    const tk = localStorage.getItem('token')
    return this.http.get(UPDATE_API + '/getplayer/' + id, {
      headers: new HttpHeaders({'Authorization': 'Bearer ' + tk})
    })
  }

  updatePlayerDetails(id: string, data: any): Observable<any> {
    const tk = localStorage.getItem('token')
    return this.http.put(UPDATE_API + '/update' + `/${id}`, {...data}, {
      headers: new HttpHeaders({'Authorization': 'Bearer ' + tk})
    })
  }
}
