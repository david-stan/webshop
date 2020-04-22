import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from './../config/local-storage-keys';
import LoginDTO from '../models/login-dto.model';
import { LOGIN_URL } from './../config/api-paths';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { 
  }

  isUserLoggedIn(): boolean {
    return localStorage.getItem(USER_ID_KEY) != null;
  }

  login(credentials: LoginDTO): Observable<any> {
    return this.http.post(LOGIN_URL, credentials);
  }

  logout(): void {
    localStorage.removeItem(USER_ID_KEY);
    localStorage.removeItem(USER_ROLE_KEY);
    localStorage.removeItem(USERNAME_KEY);
    localStorage.removeItem(USER_TOKEN_KEY);
  }
}