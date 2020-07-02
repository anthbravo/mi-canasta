import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LimitCategoryComponent } from './limit-category.component';

describe('LimitCategoryComponent', () => {
  let component: LimitCategoryComponent;
  let fixture: ComponentFixture<LimitCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LimitCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LimitCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
