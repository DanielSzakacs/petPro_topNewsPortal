import { Component, OnInit } from '@angular/core';
import {environment} from "../../environments/environment.prod";
import {HttpClient} from "@angular/common/http";
import {FlagService} from "../flagService/flag.service";
import {CookieHandlerService} from "../cookiehandlerService/cookie-handler.service";
import {UserService} from "../userService/user.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  mainPageNews = environment.mainNewsURL;
  listOfNews : object;
  listOfTopNews : object;
  languageText = environment.engText;
  user = false;


  constructor(private http: HttpClient,
              public flagService: FlagService,
              private cookieService: CookieHandlerService,
              private userService : UserService) { }

  ngOnInit() {
    this.isUserLoggedIn();
    this.manageLanguage();
    this.getAllNews();
  }

  getAllNews(){
    this.getAllTopNewsBySource('cnn');
    this.http.get(this.mainPageNews).subscribe(
      res => {
        this.listOfNews = res;
      },
      error1 => {
        console.log(error1)
      }
    );
  }

  selectNews(source) {
    let news = source.target.value;
    this.getAllTopNewsBySource(news);
    console.log(news);
    this.http.get(this.mainPageNews + '/' + news).subscribe(
      res => {
        this.listOfNews = res;
      },
      error1 => {
        console.log(error1)
      }
    );
  }

  getAllTopNewsBySource(source) {
    this.http.get(this.mainPageNews + '/' + source + '?type=top').subscribe(
      res => {
        this.listOfTopNews = res;
      },
      error1 => {
        console.log(error1)
      }
    )
  }

  manageLanguage(){
    if(this.cookieService.getCookieValue('language') == 'rus'){
      this.languageText = environment.rusText;
      this.flagService.setflagButton(this.flagService.getflagUSA());
    }else if (this.cookieService.getCookieValue('language') == 'eng'){
      this.languageText = environment.engText;
      this.flagService.setflagButton(this.flagService.getflagRUS());
    }
  }

  public turnLanguageToRus(){
    if(this.cookieService.getCookieValue('language') != 'rus'){
      this.cookieService.saveCookie('language', 'rus');
      this.manageLanguage();
    }
  }
  public turnLanguageToEng(){
    if(this.cookieService.getCookieValue('language') != 'eng'){
      this.cookieService.saveCookie('language', 'eng');
      this.manageLanguage();
    }
  }

  public isUserLoggedIn() {
    return this.userService.userIsLoggedIn()
    //return UserService.user;
  }

  public openLink(link : string) {
    if(this.isUserLoggedIn()){
      open (link);
    }else{
       alert('Need to register')
    }
  }

  // login
  public makeLogin(data){
    this.http.get( 'http://localhost:8080//login/' + data.email + '?userpassword=' + data.password).subscribe(
      res => {
        this.login(data.email);
        this.isUserLoggedIn();
        console.log('You logged in successfully')
      },
      error1 => {
        console.log(error1)
      }
    );
  }
  // registration
  public makeRegistration(data){
    this.http.get('http://localhost:8080//registration/' + data.email + '?userpassword=' + data.password).subscribe(
      res => {
        this.login(data.email);
        console.log(res);
        this.isUserLoggedIn();
      },
      error1 => {
        console.log(error1)
      }
    );
  }

  public login(data){
    this.userService.login(data.email);
  }

  public logout(){
    console.log('u try to log out');
    this.userService.logout();
  }

}
