import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';

import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';

import {RideListComponent} from "./rides/ride-list.component";

import {RideListService} from './rides/ride-list.service';
import {UserService} from "./users/user.service";
import {AppService} from "./app.service";
import {ValidatorService} from "./validator.service";
import {AppAuthGuard} from "./app.authGuard";

import {Routing} from './app.routes';
import {APP_BASE_HREF} from '@angular/common';

import {CustomModule} from './custom.module';

import {AddRideComponent} from './rides/add-ride.component';
import {EditRideComponent} from './rides/edit-ride.component';
import {DeleteRideComponent} from "./rides/delete-ride.component";
import {ClaimRideComponent} from "./rides/claim-ride.component";


import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCheckboxModule}  from "@angular/material/checkbox";
import {ProfileComponent} from "./users/profile.component";

import {RouterLinkDirectiveStub} from "./rides/router-link-directive-stub";
import {PhoneMaskDirective} from "./users/phone-mask.directive";

import {AgmCoreModule, MapsAPILoader} from "@agm/core";
import {MapsComponent} from "./maps/maps.component";
import {MapsAutocomplete} from "./mapsAutocomplete/mapsAutocomplete.component";

import * as Config from "./config.json";


var api_Key = Config.API_KEY;

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    Routing,
    CustomModule,
    MatCardModule,
    MatDatepickerModule,
    MatRadioModule,
    MatSelectModule,
    MatCheckboxModule,
    AgmCoreModule.forRoot({
      apiKey: api_Key,
      libraries: ["places"]
    })
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    RideListComponent,
    AddRideComponent,
    EditRideComponent,
    DeleteRideComponent,
    ClaimRideComponent,
    ProfileComponent,
    RouterLinkDirectiveStub,
    PhoneMaskDirective,
    MapsComponent,
    MapsAutocomplete,
  ],
  providers: [
    RideListService, AppService, AppAuthGuard, UserService, ValidatorService,
    {provide: APP_BASE_HREF, useValue: '/'},
  ],
  entryComponents: [
    AddRideComponent, EditRideComponent, DeleteRideComponent, ClaimRideComponent
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
