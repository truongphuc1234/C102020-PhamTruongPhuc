import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup,Validators} from '@angular/forms';
function comparePassword(c: AbstractControl) {
  const v =c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}
@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent implements OnInit {
registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      pwGroup: this.fb.group({
        password: '',
        confirmPassword: ''
      }, {validators: comparePassword}),
      country: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });
    this.registerForm.patchValue({
      email: 'info@example.com'
    });
  }
  onSubmit(){
    console.log(this.registerForm.value)
  }

}
