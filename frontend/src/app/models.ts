export interface City {
  UUID?: number;
  name: string;
  country?: string;
}

export interface Shipment {
  id?: number;
  originCity?: City;
  destinationCity?: City;
  freightType?: string;
  estimatedDays?: number;
  status?: string;
  createdAt?: string;
}

export interface CreateShipmentRequest {
  originCityId: number;
  destinationCityId: number;
  freightType: string;
}
