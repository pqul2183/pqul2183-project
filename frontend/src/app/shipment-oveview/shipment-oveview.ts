import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ShipmentService } from '../shipment.service';
import { Shipment } from '../models';

@Component({
  selector: 'app-shipment-oveview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './shipment-oveview.html',
  styleUrls: ['./shipment-oveview.scss'],
  providers: [DatePipe],
})
export class ShipmentOverviewComponent implements OnInit {
  shipments: Shipment[] = [];
  isLoading = true;

  constructor(private shipmentService: ShipmentService) {}

  ngOnInit(): void {
    this.shipmentService.getShipments().subscribe({
      next: (shipments) => {
        this.shipments = shipments;
        this.isLoading = false;
      },
      error: () => {
        this.shipments = [];
        this.isLoading = false;
      },
    });
  }
}

export { ShipmentOverviewComponent as ShipmentOveview };
