
import { Component, OnInit } from '@angular/core';
import { FormBuilder ,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { User } from '../user';

@Component({
  selector: 'app-registerpage',
  templateUrl: './registerpage.component.html',
  styleUrls: ['./registerpage.component.css']
})
export class RegisterpageComponent implements OnInit {
  public RegisterForm: any;
  msg="";
  //public errorMessage: string;
  user:User 
  submitted:boolean=false;
  constructor(private registerService: RegisterService,
    private _router : Router,
    private formBuilder: FormBuilder) { 
      this.forms();
    }
    checkingPassword(password: string, passwordConfirmation: string) {
      return (group: FormGroup) => {
        let passwordInput = group.controls[password],
            passwordConfirmationInput = group.controls[passwordConfirmation];
        if (passwordInput.value !== passwordConfirmationInput.value) {
          return passwordConfirmationInput.setErrors({notEquivalent: true})
        }
        else {
            return passwordConfirmationInput.setErrors(null);
        }
      }
    }
  ngOnInit(): void {
  }
  forms() {
    this.RegisterForm = this.formBuilder.group({
      usertype:['',[Validators.required]],
      email: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.minLength(8),Validators.maxLength(16),Validators.required]],
      name: ['', Validators.required],
      phone: ['', [Validators.required,]],
      cpassword: ['', Validators.required]
    },{validator: this.checkingPassword('password', 'cpassword')});
  }

  userRegister()
  { 
     this.submitted = true;
    if (this.RegisterForm.invalid) {
      alert("Enter all details");
      return;
    }
    
     console.log(this.RegisterForm.value);
     this.registerService.registerUser(this.RegisterForm.value).subscribe(
    data=>
    {
    alert("Registration successfull");
    this._router.navigate(['/registrationsuccess']);
     },
     (error:{error:any;})=>{
      console.log("Registration Failed");
      console.log(error.error);
      alert(error.error);
      //this.msg="User  with "+this.user.email+" already exits";
     // error=>alert("failed");
     })
 }
}
