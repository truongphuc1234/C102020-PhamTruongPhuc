import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AwesomeCalculatorComponent } from './awesome-calculator.component';

describe('AwesomeCalculatorComponent', () => {
  let component: AwesomeCalculatorComponent;
  let fixture: ComponentFixture<AwesomeCalculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AwesomeCalculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AwesomeCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
