import { Injectable } from '@angular/core';
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class CookieHandlerService {

  constructor(private cookieService : CookieService) { }

  public getCookieValue(key : string){
    return this.cookieService.get(key);
  }

  public saveCookie(key: string, value : string ){
    this.cookieService.set(key, value);
  }

  public delete(key : string){
    this.cookieService.delete(key);
  }

  public isUserCookieExists(){
    return this.cookieService.check('user');
  }
}
