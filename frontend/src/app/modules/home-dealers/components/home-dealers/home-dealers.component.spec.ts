import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeDealersComponent } from './home-dealers.component';

describe('HomeDealersComponent', () => {
  let component: HomeDealersComponent;
  let fixture: ComponentFixture<HomeDealersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeDealersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeDealersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
