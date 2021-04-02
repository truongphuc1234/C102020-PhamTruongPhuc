import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {
  createStudentForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    age: new FormControl(),
    mark: new FormControl(),
    image: new FormControl(),
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    st
  }
}
