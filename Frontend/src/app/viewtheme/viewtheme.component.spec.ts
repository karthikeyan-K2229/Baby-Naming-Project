import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewthemeComponent } from './viewtheme.component';

describe('ViewthemeComponent', () => {
  let component: ViewthemeComponent;
  let fixture: ComponentFixture<ViewthemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewthemeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewthemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
