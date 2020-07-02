import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterDealerComponent } from './footer-dealer.component';

describe('FooterDealerComponent', () => {
  let component: FooterDealerComponent;
  let fixture: ComponentFixture<FooterDealerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterDealerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterDealerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
