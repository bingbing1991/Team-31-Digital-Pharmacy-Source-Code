import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user = new User();
msg='';

  constructor(private _service : RegistrationService,
              private _router : Router  )
  {

  }

  ngOnInit(): void {
  }

  loginUser()
  {
    this._service.loginUserFromJavaSide(this.user).subscribe(
      data => {
        console.log("response received");
        this._router.navigate(['/homepage'])
    },
      error => { 
        console.log("exception occured");
        this.msg = "Invalid email or password";
      }
    )
  }

  goToRegistrationPage()
  {
    this._router.navigate(['/registration'])
  }
}
