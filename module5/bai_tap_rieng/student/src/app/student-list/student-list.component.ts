import {Component, Input, OnInit} from '@angular/core';
import {studentRepository} from '../student-info/model/StudentRepository';
import {IStudent} from '../student-info/model/IStudent';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students = studentRepository;
  student: IStudent;

  constructor() {
  }

  ngOnInit(): void {
  }

  detail(student: IStudent) {
    this.student = student;
  }
}
