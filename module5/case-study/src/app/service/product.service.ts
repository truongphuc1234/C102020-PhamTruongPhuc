import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public API = 'http://localhost:3000/product';

  constructor(public http: HttpClient) {
  }

  getAllProduct(): Observable<any> {
    return this.http.get(this.API);
  }
  getProductById(productId): Observable<any> {
    return this.http.get(this.API + '/' + productId);
  }
}
