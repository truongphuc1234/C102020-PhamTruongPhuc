import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {OrderService} from '../../../service/order.service';
import {ProductService} from '../../../service/product.service';
import {Router} from '@angular/router';
import {ErrorStateMatcher} from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-stock-create',
  templateUrl: './stock-create.component.html',
  styleUrls: ['./stock-create.component.css']
})
export class StockCreateComponent implements OnInit {
  public formCreateStock: FormGroup;
  minDate: Date = new Date(1900);
  maxDate: Date = new Date();
  matcher = new MyErrorStateMatcher();
  products;

  constructor(public formBuilder: FormBuilder,
              public orderService: OrderService,
              public productService: ProductService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.formCreateStock = this.formBuilder.group({
      id: ['', [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]],
      productId: ['', [Validators.required]],
      quantity: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      dateInbound: ['', [Validators.required]],
      dateProduct: ['', [Validators.required]],
      dateExpired: ['', [Validators.required]]
    });
    this.productService.getAllProduct().subscribe((data => {
      this.products = data;
      console.log(this.products);
    }));
  }

  createNewStock() {
    this.orderService.createOrder(this.formCreateStock.value).subscribe(data => {
      this.router.navigateByUrl('stock-list');
    });
  }
}
