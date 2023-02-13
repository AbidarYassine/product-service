import { TestBed } from '@angular/core/testing';

import { ProductFacade } from './product-facade';

describe('ProductFacadeService', () => {
  let service: ProductFacade;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductFacade);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
