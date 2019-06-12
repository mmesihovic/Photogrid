import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { FormGroup,FormControl, FormBuilder, Validators } from '@angular/forms';
import { Tag } from 'src/app/models/tag';

@Component({
  selector: 'new-post-component',
  templateUrl: './newPost.component.html',
})

export class NewPostComponent {
  public imagePath;
  imgURL: any;
  public message: string;
  description : string;
  newPost : Post;
  uploadForm : FormGroup;

  constructor(private fb: FormBuilder,
    /*private postService: PostService*/) {
      this.uploadForm = this.fb.group({
        description: ['', Validators.compose([Validators.required, Validators.maxLength(350)])],
        tags: ['', Validators.compose([])],
      })
    }


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

  publishPost() {
    this.newPost = new Post();
    this.newPost.description = this.uploadForm.get('description').value;
    let tagsString = this.uploadForm.get('tags').value;
    var tags = tagsString.split('#');
    let tagList = [];
    tags.forEach( el => {
      tagList.push(new Tag({id: null, name: el}));
    });
    this.newPost.tags = tagList;
  }
}
