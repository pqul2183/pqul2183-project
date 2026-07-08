import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShipmentService } from '../shipment.service';
import { City, Shipment } from '../models';

@Component({
  selector: 'app-send-package',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './send-package.html',
  styleUrls: ['./send-package.scss'],
})
export class SendPackageComponent implements OnInit {
  form!: FormGroup;
  cities: City[] = [];
  submitted = false;
  successMessage = '';

  constructor(
    private fb: FormBuilder,
    private shipmentService: ShipmentService,
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      originCityId: [null, Validators.required],
      destinationCityId: [null, Validators.required],
      freightType: ['AIR', Validators.required],
    });

    this.shipmentService.getCities().subscribe({
      next: (cities) => {
        this.cities = cities;
      },
      error: () => {
        this.successMessage = 'Could not load cities.';
      },
    });
  }

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const payload = this.form.value;

    if (payload.originCityId === payload.destinationCityId) {
      this.successMessage = 'Origin and destination must be different.';
      return;
    }

    this.submitted = true;
    this.successMessage = '';

    this.shipmentService.createShipment(payload).subscribe({
      next: (shipment: Shipment) => {
        this.submitted = false;
        this.successMessage = `Shipment created successfully with estimated delivery ${shipment.estimatedDays ?? '?'} days.`;
        this.form.reset({ freightType: 'AIR' });
      },
      error: () => {
        this.submitted = false;
        this.successMessage = 'Could not create shipment.';
      },
    });
  }
}

export { SendPackageComponent as SendPackage };
