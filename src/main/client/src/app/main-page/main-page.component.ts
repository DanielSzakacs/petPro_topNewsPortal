import { Component, OnInit } from '@angular/core';
import { environment} from "../../environments/environment.prod";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  mainPageNews = environment.mainNewsURL;
  listOfNews : Object;
  listOfTopNews : Object;
  sportLine: Object;
  languageText = environment.engText;

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
        console.log(res)
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
        console.log(res)
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
        console.log("Get all the Top news was Good.")
        console.log(this.listOfTopNews)
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

  changeLanguage() {
    if(this.languageText == environment.engText){
      this.languageText = environment.rusText;
    }else{
      this.languageText = environment.engText;
    }
  }

}
