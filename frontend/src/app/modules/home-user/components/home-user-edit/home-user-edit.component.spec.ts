import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeUserDetailComponent } from './home-user-detail.component';

describe('HomeUserDetailComponent', () => {
  let component: HomeUserDetailComponent;
  let fixture: ComponentFixture<HomeUserDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeUserDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeUserDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
