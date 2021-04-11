import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {OrderService} from '../../../service/order.service';

@Component({
  selector: 'app-stock-delete',
  templateUrl: './stock-delete.component.html',
  styleUrls: ['./stock-delete.component.css']
})
export class StockDeleteComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<StockDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public orderService: OrderService) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data);
  }

  deleteOrder() {
    this.orderService.deleteOrder(this.data.orderDelete.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
