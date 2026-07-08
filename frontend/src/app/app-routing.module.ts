import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SendPackageComponent } from './send-package/send-package';
import { ShipmentOverviewComponent } from './shipment-oveview/shipment-oveview';

const routes: Routes = [
  { path: '', redirectTo: '/send', pathMatch: 'full' },
  { path: 'send', component: SendPackageComponent },
  { path: 'overview', component: ShipmentOverviewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
