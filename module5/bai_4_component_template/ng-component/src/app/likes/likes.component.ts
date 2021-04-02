import {Component, OnInit} from '@angular/core';
import {faThumbsUp} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-likes',
  templateUrl: './likes.component.html',
  styleUrls: ['./likes.component.css']
})
export class LikesComponent implements OnInit {
  faThumbsUp = faThumbsUp;
  likes = 0;

  likeThis() {
    this.likes++;
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
