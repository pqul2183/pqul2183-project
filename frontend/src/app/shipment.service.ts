import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City, CreateShipmentRequest, Shipment } from './models';

@Injectable({ providedIn: 'root' })
export class ShipmentService {
  constructor(private http: HttpClient) {}

  getCities(): Observable<City[]> {
    return this.http.get<City[]>('http://localhost:8080/api/cities');
  }

  createShipment(data: CreateShipmentRequest): Observable<Shipment> {
    return this.http.post<Shipment>('http://localhost:8080/api/shipments', data);
  }

  getShipments(): Observable<Shipment[]> {
    return this.http.get<Shipment[]>('http://localhost:8080/api/shipments');
  }
}
