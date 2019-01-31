import { Component, OnInit } from '@angular/core';
import {environment} from "../../environments/environment.prod";
import {HttpClient} from "@angular/common/http";

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
 // TODO
  flagButton = "http://icons.iconarchive.com/icons/wikipedia/flags/24/US-United-States-Flag-icon.png";
  flagUSA = "http://icons.iconarchive.com/icons/wikipedia/flags/24/US-United-States-Flag-icon.png";
  flagRUS = "http://icons.iconarchive.com/icons/wikipedia/flags/24/RU-Russia-Flag-icon.png";

  constructor(private http: HttpClient) { }

  ngOnInit() {
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
        // console.log(error1)
      }
    );
  }

  selectNews(source) {
    let news = source.target.value;
    this.getAllTopNewsBySource(news);
    // console.log(news);
    this.http.get(this.mainPageNews + '/' + news).subscribe(
      res => {
        this.listOfNews = res;
      },
      error1 => {
        // Console.log(error1)
      }
    );
  }

  getAllTopNewsBySource(source) {
    this.http.get(this.mainPageNews + '/' + source + '?type=top').subscribe(
      res => {
        this.listOfTopNews = res;
      },
      error1 => {
        // console.log(error1)
      }
    )
  }

  getSportLine() {
    this.http.get(this.mainPageNews + '/bbc-sport' ).subscribe(
      res => {
        this.sportLine = res;
      },
      error1 => {
        // console.log(error1)
      }
    )
  }

  changeLanguage() {
    if(this.languageText == environment.engText){
      this.languageText = environment.rusText;
      this.flagButton = this.flagRUS;
    }else{
      this.languageText = environment.engText;
      this.flagButton = this.flagUSA;
    }
  }

}
