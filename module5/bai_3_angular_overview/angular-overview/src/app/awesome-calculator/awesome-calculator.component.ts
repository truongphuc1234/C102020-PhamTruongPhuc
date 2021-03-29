import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-awesome-calculator',
  templateUrl: './awesome-calculator.component.html',
  styleUrls: ['./awesome-calculator.component.css']
})
export class AwesomeCalculatorComponent implements OnInit {
  first: number;
  second: number;
  output: number;
  operator = '+';

  onFirstChange(value) {
    this.first = Number(value);
  }

  onSecondChange(value) {
    this.second = Number(value);
  }

  onSelectChange(value) {
    this.operator = value;
  }

  calculate() {
    switch (this.operator) {
      case '+':
        this.output = this.first + this.second;
        break;
      case '-':
        this.output = this.first - this.second;
        break;
      case '*':
        this.output = this.first * this.second;
        break;
      case '/':
        this.output = this.first / this.second;
        break;
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
