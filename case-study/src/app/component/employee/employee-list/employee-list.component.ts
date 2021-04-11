import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../service/employee.service';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteDialogComponent} from '../employee-delete-dialog/employee-delete-dialog.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employees;
  term: string;
  p: number;

  constructor(public employeeService: EmployeeService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
  }

  openDialog(employeeId): void {
    this.employeeService.getEmployeeById(employeeId).subscribe(data => {
      const dialogRef = this.dialog.open(EmployeeDeleteDialogComponent, {
        width: '500px',
        data: {employeeDelete: data}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

}
