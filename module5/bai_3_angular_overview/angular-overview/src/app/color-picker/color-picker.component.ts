import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  background = '#00e067';

  constructor() {
  }

  ngOnInit(): void {
  }

  onChange(value) {
    this.background = value;
  }
}
