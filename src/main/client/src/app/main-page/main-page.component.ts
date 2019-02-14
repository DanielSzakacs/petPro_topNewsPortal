import { Component, OnInit } from '@angular/core';
import {environment} from "../../environments/environment.prod";
import {HttpClient} from "@angular/common/http";
import {FlagService} from "../flagService/flag.service";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  mainPageNews = environment.mainNewsURL;
  listOfNews : object;
  listOfTopNews : object;
  sportLine: object; //Not used
  languageText = environment.engText;

  constructor(private http: HttpClient ,
              public flagService: FlagService,
              private cookieService: CookieService) { }

  ngOnInit() {
    this.manageLanguage();
    this.getAllNews();
    this.getSportLine();
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

  getSportLine() {
    this.http.get(this.mainPageNews + '/bbc-sport' ).subscribe(
      res => {
        this.sportLine = res;
      },
      error1 => {
        console.log(error1)
      }
    )
  }

  manageLanguage(){
    if(this.cookieService.get('language') == 'rus'){
      this.languageText = environment.rusText;
      this.flagService.setflagButton(this.flagService.getflagUSA());
    }else if (this.cookieService.get('language') == 'eng'){
      this.languageText = environment.engText;
      this.flagService.setflagButton(this.flagService.getflagRUS());
    }
  }

  public changeLanguageCookie(){
    if(this.cookieService.get('language') == 'eng'){
      this.cookieService.set('language', 'rus');
    }else {
      this.cookieService.set('language', 'eng')
    }
    this.manageLanguage();
  }

}
