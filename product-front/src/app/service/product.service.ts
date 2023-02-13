import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable, Subject} from "rxjs";
import {Product} from "../model/product";

/**
 * Product Service communicates with the Api
 */
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  readonly API = 'http://localhost:8080/api/products';
  headers = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin', 'http://localhost:4200')
    .set('Access-Control-Allow-Credentials', 'true')

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.API}/`, {headers: this.headers});
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.API}/${id}`, {headers: this.headers});
  }

  save(product: Product): Observable<any> {
    const {libelle, description, price, quantite} = product;
    return this.httpClient.post(`${this.API}/`, {libelle, description, price, quantite}, {headers: this.headers});
  }

  getProducts(search: string) {
    let params = new HttpParams().set('keyword', search);
    return this.httpClient.get(`${this.API}/search`, {params: params});
  }
}
