import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutFamilyComponent } from './layout-family.component';

describe('LayoutFamilyComponent', () => {
  let component: LayoutFamilyComponent;
  let fixture: ComponentFixture<LayoutFamilyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LayoutFamilyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LayoutFamilyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
