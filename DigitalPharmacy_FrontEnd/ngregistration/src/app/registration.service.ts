import { Injectable } from '@angular/core';
import { fromEventPattern, Observable } from 'rxjs';
import { User } from './user';
import { HttpClient } from '@angular/common/http' 

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  //inject the https client dependencies into the constructor into the service
  constructor(private _http : HttpClient) { }

  public loginUserFromJavaSide(user: User):Observable<any>
  {
    return this._http.post<any>("http://userservice-env.eba-5yt5fhc2.us-east-2.elasticbeanstalk.com/users/LoginUser",user);
  }

  public registerUserFromJavaSide(user: User):Observable<any>
  {
    return this._http.post<any>("http://userservice-env.eba-5yt5fhc2.us-east-2.elasticbeanstalk.com/users/registerUser",user);
  }
}
