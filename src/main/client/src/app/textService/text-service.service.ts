import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TextServiceService {

  constructor() { }

  private _rusText: {'World':'Мир', 'Business':'Бизнес',
    'Sport':'Спорт', 'Crypto':'Крипто',
    'In_focus':'Фокус', 'Top_news':'Новости',
    'Logo': 'ЛОГО', 'Around_the_world': 'Мир', 'All_news': 'Все'};

  private _engText: {'World':'World', 'Business':'Business',
    'Sport':'Sport', 'Crypto':'Crypto',
    'In_focus':'In focus', 'Top_news':'Top stories',
    'Logo': 'LOGO', 'Around_the_world': 'Around the world',
    'All_news': 'All news'};


  get rusText() {
    return this._rusText;
  }

  get engText() {
    return this._engText;
  }
}
