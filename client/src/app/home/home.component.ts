import {Component} from '@angular/core';
import {AppService} from "../app.service";

@Component({
  templateUrl: 'home.component.html',
  styleUrls: ['./home.component.scss'],

})

export class HomeComponent {
  public text: string;

  constructor(public appService: AppService) {
    this.text = 'Mongo lab';
  }
}
