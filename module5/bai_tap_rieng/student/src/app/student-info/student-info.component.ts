import {Component, OnInit} from '@angular/core';
import {IStudent} from './model/IStudent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: 'Phúc',
    age: 29,
    mark: 9,
    avatarImg: 'https://cdn.vietnambiz.vn/2020/3/23/9005608425724062764144382127330218338156544n-1584933586723443851956.jpg',
  };
  student1: IStudent = {
    id: 2,
    name: 'Thịnh',
    age: 25,
    mark: 8,
    avatarImg: 'https://i.pinimg.com/originals/57/fb/31/57fb3190d0cc1726d782c4e25e8561e9.png',
  };

  ngOnInit(): void {
  }
}
