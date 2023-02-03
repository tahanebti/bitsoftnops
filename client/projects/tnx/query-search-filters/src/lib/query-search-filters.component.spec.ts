import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuerySearchFiltersComponent } from './query-search-filters.component';

describe('QuerySearchFiltersComponent', () => {
  let component: QuerySearchFiltersComponent;
  let fixture: ComponentFixture<QuerySearchFiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuerySearchFiltersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuerySearchFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
