import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SendPackageComponent } from './send-package/send-package';
import { ShipmentOveview } from './shipment-oveview/shipment-oveview';

const routes: Routes = [
  { path: '', redirectTo: '/send', pathMatch: 'full' },
  { path: 'send', component: SendPackageComponent },
  { path: 'overview', component: ShipmentOveview },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
