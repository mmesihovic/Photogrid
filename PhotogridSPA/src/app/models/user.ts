export class User {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    birthDate: Date;
    username: string;
    password: string;

    constructor(data ?: any) {
      if(!!data) {
        this.id = data.id;
        this.firstName = data.firstName;
        this.lastName = data.lastName;
        this.email = data.email;
        this.birthDate = data.birthDate;
        this.username = data.username;
        this.password = data.password;
      }
    }
}
