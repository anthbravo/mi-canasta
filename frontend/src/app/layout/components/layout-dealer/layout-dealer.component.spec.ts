import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutDealerComponent } from './layout-dealer.component';

describe('LayoutDealerComponent', () => {
  let component: LayoutDealerComponent;
  let fixture: ComponentFixture<LayoutDealerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LayoutDealerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LayoutDealerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
