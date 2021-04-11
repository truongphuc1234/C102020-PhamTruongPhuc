import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteDialogComponent} from '../employee/employee-delete-dialog/employee-delete-dialog.component';
import {OrderService} from '../../service/order.service';
import {ProductService} from '../../service/product.service';
import {StockDeleteComponent} from './stock-delete/stock-delete.component';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  public stocks;
  term: string;
  p: number;
  products: any;

  constructor(public orderService: OrderService,
              public productService: ProductService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.orderService.getAllOrders().subscribe(data => {
      this.stocks = data;
      console.log(this.stocks);
    });
    this.productService.getAllProduct().subscribe((data => {
      this.products = data;
    }));
  }

  openDialog(orderId): void {
    this.orderService.getOrderById(orderId).subscribe(data => {
      console.log(data);
      const dialogRef = this.dialog.open(StockDeleteComponent, {
        width: '500px',
        data: {orderDelete: data, productDelete: this.findProductById(data.productId)}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  findProductById(productId): any {
    for (let product of this.products) {
      if (product.id == productId) {
        return product;
      }
      return null;
    }
  }
}

