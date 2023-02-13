import {Injectable} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ProductState} from "../state/product-state";
import {Observable, Subject} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductFacade {

  constructor(
    private productService: ProductService,
    private productState: ProductState,
  ) {
    this.loadProducts()
  }

  loadProducts() {
    this.productService.findAll().subscribe(products => {
      console.log("products ", products);
      this.productState.setProducts(products)
    })
  }

  addProduct(product: Product): Observable<string> {
    let message = new Subject<string>();
    this.productService.save(product).subscribe(response => {
      if (response.id) {
        this.productState.addProduct(response);
        message.next("Ok");
      } else {
        message.next(response.message);
      }
    }, error => {
      this.setLoading(false);
      message.next(this.handleError(error));
    })

    return message;
  }

  handleError(error: any): string {
    console.log("ERROR {} ", error);
    let text = "";

    if (typeof error.error.message == 'string') {
      text = error.error.message;
    } else {
      for (let i = 0; i < error.error.message.length; i++) {
        if (i == error.error.message.length - 1) text += `${error.error.message[i]}`
        else text += `${error.error.message[i]} | `
      }
    }
    return text;
  }

  getProducts$(): Observable<Product[]> {
    return this.productState.getProducts();
  }

  getError$() {
    return this.productState.getError$();
  }

  setError(message: string) {
    this.productState.setError(message);
  }

  getLoading$() {
    return this.productState.isLoading$();
  }

  setLoading(value: boolean) {
    this.productState.setLoading(value);
  }

  searchProduct(search: string) {
    return this.productService.getProducts(search);
  }
}
