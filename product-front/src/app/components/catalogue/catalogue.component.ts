import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {ProductFacade} from "../../facade/product-facade";

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css'],
})
export class CatalogueComponent implements OnInit {

  products$: Observable<Product[]> = new Observable<Product[]>();
  productsSearch$: Observable<Product[]> = new Observable<Product[]>();

  search: string = "";

  newProduct: Product = {
    libelle: "",
    description: "",
    price: 0.0,
    quantite: 0
  }

  rows: Product[] = [];
  add: boolean = false;

  constructor(
    private productFacade: ProductFacade,
  ) {
  }

  ngOnInit() {
    this.getAll();
  }

  onSearch() {
    if (!(this.search === "")) {
      this.getByKeyWord();
    } else {
      this.getAll();
    }
  }

  getAll() {
    this.products$ = this.productFacade.getProducts$();
    this.products$.subscribe((products) => {
      this.rows = products;
      console.log("Products {}", products);
    });
  }

  getByKeyWord() {
    // @ts-ignore
    this.productsSearch$ = this.productFacade.searchProduct(this.search);
    this.productsSearch$.subscribe((products) => {
      this.rows = products;
      console.log("Products {}", products);
    });
  }


  toggleAddForm(event: any) {
    event.preventDefault();
    this.add = !this.add;
  }

  submit(event: any) {
    event.preventDefault();
    this.productFacade.addProduct(this.newProduct);
    this.reset();
  }

  private reset() {
    this.newProduct = {
      libelle: "",
      description: "",
      price: 0.0,
      quantite: 0
    }
  }
}
