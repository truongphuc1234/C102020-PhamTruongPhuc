import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Article} from '../article.model';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {
  public isCollapsed = false;

  article: Article = {
    title: '',
    url: '',
  };

  @Output() addNewArticle: EventEmitter<Article> = new EventEmitter();

  ngOnInit(): void {
  }

  addArticle(title, url) {
    this.article.title = title;
    this.article.url = url;
    this.addNewArticle.emit(this.article);
  }

  toggle() {
    this.isCollapsed = !this.isCollapsed;
  }
}
