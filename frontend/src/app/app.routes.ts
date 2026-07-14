import { Routes } from '@angular/router';
import { SendPackageComponent } from './send-package/send-package';
import { ShipmentOveview } from './shipment-oveview/shipment-oveview';

export const routes: Routes = [
  { path: '', redirectTo: '/send', pathMatch: 'full' },
  { path: 'send', component: SendPackageComponent },
  { path: 'overview', component: ShipmentOveview },
];
