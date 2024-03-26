import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActuacionesComponent } from './actuaciones.component';

describe('ActuacionesComponent', () => {
  let component: ActuacionesComponent;
  let fixture: ComponentFixture<ActuacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActuacionesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActuacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
