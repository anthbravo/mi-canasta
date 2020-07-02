import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterFamilyComponent } from './footer-family.component';

describe('FooterFamilyComponent', () => {
  let component: FooterFamilyComponent;
  let fixture: ComponentFixture<FooterFamilyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterFamilyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterFamilyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
