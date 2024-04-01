import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routes } from './app.routes';
import { RoutingModule } from './app.routing.module';

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    RoutingModule
  ],
  exports: [
    RouterModule
  ],
  providers: []
})
export class AppModule { }
