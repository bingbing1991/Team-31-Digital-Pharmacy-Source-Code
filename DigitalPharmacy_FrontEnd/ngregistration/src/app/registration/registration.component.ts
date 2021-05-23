import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user = new User();
  msg='';

  constructor(private _service : RegistrationService,
    private _router : Router )
  {

  }

  ngOnInit(): void {
  }

  registerUser()
  {
    this._service.registerUserFromJavaSide(this.user).subscribe(
      data => {
        console.log("response received");
        this._router.navigate([''])
    },
      error => { 
        console.log("exception occured");
        this.msg=error.error;
      }
    )
  }

  goToLoginPage()
  {
    this._router.navigate([''])
  }
}
