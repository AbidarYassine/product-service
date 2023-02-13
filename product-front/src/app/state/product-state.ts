import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductState {


  // @ts-ignore
  private products$ = new BehaviorSubject<Product[]>(null)
  private loading$ = new BehaviorSubject<boolean>(false)
  private error$ = new BehaviorSubject<string>("")

  constructor() {
  }

  getProducts() {
    return this.products$.asObservable();
  }

  setProducts(products: Product[]) {
    this.products$.next(products)
  }

  addProduct(product: Product) {
    const products = this.products$.getValue()

    if (products == null) {
      this.products$.next(new Array(product))
    } else {
      this.products$.next([...products, product])
    }
  }

  isLoading$() {
    return this.loading$.asObservable()
  }

  setLoading(value: boolean) {
    this.loading$.next(value)
  }

  setError(message: string) {
    this.error$.next(message)
  }

  getError$() {
    return this.error$
  }
}
