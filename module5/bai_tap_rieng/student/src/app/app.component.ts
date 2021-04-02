import {Component} from '@angular/core';
import {IStudent} from './student/student.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student';
  detailStudent: IStudent;

  changeStudentDetail(student: IStudent) {
    this.detailStudent = student;
  }

}
