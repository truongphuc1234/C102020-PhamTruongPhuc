import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {EmployeeService} from '../../../service/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ErrorStateMatcher} from '@angular/material/core';


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  public editFormEmployee: FormGroup;
  minDate: Date = new Date(1900);
  maxDate: Date = new Date();
  matcher = new MyErrorStateMatcher();
  employeeId;

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.editFormEmployee = this.formBuilder.group({
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
    this.activatedRoute.params.subscribe(data => {
      this.employeeId = data.id;
      this.employeeService.getEmployeeById(this.employeeId).subscribe(originEmployee => {
        this.editFormEmployee.patchValue(originEmployee);
        console.log(this.editFormEmployee);
      });
    });
  }

  editEmployee() {
    this.employeeService.editEmployee(this.employeeId, this.editFormEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list');
    });
  }
}
