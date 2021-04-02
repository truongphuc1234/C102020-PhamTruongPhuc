import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from '../app.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() students: IStudent[];
  @Output() showDetailEvent: EventEmitter<IStudent> = new EventEmitter<IStudent>();

  constructor() {
  }

  ngOnInit(): void {
  }

  showDetail(student: IStudent) {
    this.showDetailEvent.emit(student);
  }
}
