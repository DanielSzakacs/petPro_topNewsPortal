import {HttpClient} from "@angular/common/http";
import {CookieHandlerService} from "../cookiehandlerService/cookie-handler.service";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient,
              private userCookieHandler : CookieHandlerService) { }

  public static user = false;

  public userIsLoggedIn() {
    if(this.userCookieHandler.isUserCookieExists()){
      UserService.user = true;
    }else{
      UserService.user = false
    }
    return UserService.user;
  }

  public logout(){
    console.log(this.userCookieHandler.isUserCookieExists());
    this.userCookieHandler.delete('user');
  }

  public login(email: string){
    this.userCookieHandler.saveCookie('user', email);
  }
  //
  // public sendLoginDataBackend(data){
  //   this.http.get( 'http://localhost:8080//login/' + data.email + '?userpassword=' + data.password).subscribe(
  //     res => {
  //       console.log(res);
  //       console.log('you passed your login data');
  //     },
  //     error1 => {
  //       console.log(error1)
  //     }
  //   );
  // }
  //
  // public sendUserDataForRegistration(data){
  //   this.http.get('http://localhost:8080//registration/' + data.email + '?userpassword=' + data.password).subscribe(
  //     res => {
  //       console.log(res)
  //     },
  //     error1 => {
  //       console.log(error1)
  //     }
  //   );
  // }

}
