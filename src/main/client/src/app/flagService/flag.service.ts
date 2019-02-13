import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlagService {

  constructor() { }

  private _flagButton = "http://icons.iconarchive.com/icons/wikipedia/flags/24/RU-Russia-Flag-icon.png";
  private _flagUSA = "http://icons.iconarchive.com/icons/wikipedia/flags/24/US-United-States-Flag-icon.png";
  private _flagRUS = "http://icons.iconarchive.com/icons/wikipedia/flags/24/RU-Russia-Flag-icon.png";


  public getflagButton(): string {
    return this._flagButton;
  }

  public getflagUSA(): string {
    return this._flagUSA;
  }

  public getflagRUS(): string {
    return this._flagRUS;
  }

  public setflagButton(value: string) {
    this._flagButton = value;
  }
}
