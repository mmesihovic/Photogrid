import { Component } from '@angular/core';

@Component({
  selector: 'new-post-component',
  templateUrl: './newPost.component.html',
})

export class NewPostComponent {
  public imagePath;
  imgURL: any;
  public message: string;
  description : string;

  preview(files) {
    if (files.length === 0){
      return;
    }

    var mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = 'Only images are supported.';
      return;
    }

    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.imgURL = reader.result;
    }
  }
}
