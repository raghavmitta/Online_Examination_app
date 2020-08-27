export class Register{
  
    login: Login= new Login();
    name:string;
    state:string;
    city:string;
    subject:string;
    dob: Date;
    gradyear: number;
  }
 export class Login{
    email_id: string;
    password: string;
    acesstype: string= "Student";
  };

  