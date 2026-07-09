import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ShipmentService } from '../shipment.service';
import { Shipment } from '../models';
import { Observable, of } from 'rxjs';
import { catchError, finalize } from 'rxjs/operators';

@Component({
  selector: 'app-shipment-oveview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './shipment-oveview.html',
  styleUrls: ['./shipment-oveview.scss'],
  providers: [DatePipe],
})
export class ShipmentOverviewComponent implements OnInit {
  shipments$: Observable<Shipment[]> | null = null;
  isLoading = true;

  constructor(private shipmentService: ShipmentService) {}

  ngOnInit(): void {
    this.loadShipments();
  }

  private loadShipments(): void {
    this.isLoading = true;
    this.shipments$ = this.shipmentService.getShipments().pipe(
      catchError(() => of([])),
      finalize(() => {
        this.isLoading = false;
      })
    );
  }

  
}