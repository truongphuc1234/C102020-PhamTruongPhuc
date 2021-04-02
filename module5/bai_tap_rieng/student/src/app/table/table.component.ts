import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from '../student/student.model';
import {students} from '../student/student.repository';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  students: IStudent[] = students;
  @Output() showDetailEvent: EventEmitter<IStudent> = new EventEmitter<IStudent>();

  constructor() {
  }

  ngOnInit(): void {
  }

  showDetail(student: IStudent) {
    this.showDetailEvent.emit(student);
  }
}
