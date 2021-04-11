import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  public API = 'http://localhost:3000/stock';

  constructor(public http: HttpClient) {
  }

  getAllOrders(): Observable<any> {
    return this.http.get(this.API);
  }

  createOrder(order): Observable<any> {
    return this.http.post(this.API, order);
  }

  getOrderById(orderId): Observable<any> {
    return this.http.get(this.API + '/' + orderId);
  }

  deleteOrder(orderId): Observable<any> {
    return this.http.delete(this.API + '/' + orderId);
  }
}
