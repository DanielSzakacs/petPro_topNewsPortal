import { TestBed } from '@angular/core/testing';

import { CookieHandlerService } from './cookie-handler.service';

describe('CookieHandlerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CookieHandlerService = TestBed.get(CookieHandlerService);
    expect(service).toBeTruthy();
  });
});
