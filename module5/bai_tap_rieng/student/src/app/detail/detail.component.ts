import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from '../app.component';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  isEdit = false;
  @Input() student: IStudent;

  constructor() { }

  ngOnInit(): void {
  }

  editToggle() {
    this.isEdit = !this.isEdit;
  }
}
