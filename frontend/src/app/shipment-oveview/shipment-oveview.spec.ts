import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipmentOveview } from './shipment-oveview';

describe('ShipmentOveview', () => {
  let component: ShipmentOveview;
  let fixture: ComponentFixture<ShipmentOveview>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShipmentOveview],
    }).compileComponents();

    fixture = TestBed.createComponent(ShipmentOveview);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
