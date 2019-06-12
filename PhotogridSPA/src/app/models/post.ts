import { Tag } from './tag';

export class Post {
  id: number;
  createdAt: Date;
  description: string;
  userID: number;
  tags: Tag[];

  constructor(data ?: any) {
    if(!!data) {
      this.id = data.id;
      this.createdAt = data.createdAt;
      this.description = data.description;
      this.userID = data.userID;
      this.tags = data.tags;
    }
  }
}
