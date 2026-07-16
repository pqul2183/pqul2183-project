import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShipmentService } from '../shipment.service';
import { Shipment } from '../models';
import { Observable, of } from 'rxjs';
import { catchError, finalize, map, shareReplay } from 'rxjs/operators';

@Component({
  selector: 'app-shipment-oveview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './shipment-oveview.html',
  styleUrls: ['./shipment-oveview.scss'],
})
export class ShipmentOveview implements OnInit {
  shipments$: Observable<Shipment[]> | null = null;
  isLoading = true;
  loadError = false;

  constructor(private shipmentService: ShipmentService) {}

  ngOnInit(): void {
    console.log('Shipment overview initialized');
    this.loadShipments();
  }

  private loadShipments(): void {
    this.isLoading = true;
    this.loadError = false;

    this.shipments$ = this.shipmentService.getShipments().pipe(
      map((shipments) =>
        (shipments || []).map((shipment: any) => ({
          ...shipment,
          originCity: shipment.originCity || shipment.origin || null,
          destinationCity: shipment.destinationCity || shipment.destination || null,
          freightType: shipment.freightType || shipment.freight || null,
          estimatedDays: shipment.estimatedDays ?? shipment.estimated_days ?? null,
          status: shipment.status || null,
          createdAt: shipment.createdAt || shipment.created_at || null,
        }))
      ),
      catchError((error) => {
        console.error('Failed to load shipments', error);
        this.loadError = true;
        return of([]);
      }),
      finalize(() => {
        this.isLoading = false;
      }),
      shareReplay(1)
    );

    this.shipments$.subscribe({
      next: (shipments) => console.log('Shipments loaded', shipments),
      error: (error) => console.error('Shipment subscription error', error),
    });
  }
}