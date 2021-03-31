import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-likes',
  templateUrl: './likes.component.html',
  styleUrls: ['./likes.component.css']
})
export class LikesComponent {
  likes = 0;

  likeThis() {
    this.likes++;
  }

}
