import { TestBed } from '@angular/core/testing';

import { QuerySearchFiltersService } from './query-search-filters.service';

describe('QuerySearchFiltersService', () => {
  let service: QuerySearchFiltersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuerySearchFiltersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
