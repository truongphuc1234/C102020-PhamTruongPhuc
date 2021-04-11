import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {EmployeeService} from '../../../service/employee.service';
import {Router} from '@angular/router';
import {ErrorStateMatcher} from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  public formCreateEmployee: FormGroup;
  minDate: Date = new Date(1900);
  maxDate: Date = new Date();
  matcher = new MyErrorStateMatcher();

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.formCreateEmployee = this.formBuilder.group({
      employeeName: ['', [Validators.required]],
      position: ['', [Validators.required]],
      educationDegree: ['', [Validators.required]],
      division: ['', [Validators.required]],
      dateOfBirth: ['', [Validators.required]],
      identityNumber: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      salary: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|[\(]84[\)][\+]90|[\(]84[\)][\+]91)[0-9]{7}$')]],
      address: ['', [Validators.required]]
    });
  }

  createNewEmployee() {
    this.employeeService.createNewEmployee(this.formCreateEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list');
    });
  }
}
