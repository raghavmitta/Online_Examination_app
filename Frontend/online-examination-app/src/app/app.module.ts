import { RemoveQuestionComponent } from "./removequestion/removequestion.component";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExaminationInstructionComponent } from './examination-instruction/examination-instruction.component';
import { LoadQuestionsComponent } from './load-questions/load-questions.component';
import { HttpClientModule} from '@angular/common/http';
import { ShowresultComponent } from './showresult/showresult.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AddquestionComponent } from './addquestion/addquestion.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { StuportalComponent } from './stuportal/stuportal.component';
import { SelectexamComponent } from './selectexam/selectexam.component';
import { PdfGenerateComponent } from './pdf-generate/pdf-generate.component';



@NgModule({
  declarations: [
    AppComponent,
    ExaminationInstructionComponent,
    LoadQuestionsComponent,
    ShowresultComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AddquestionComponent,
    AdmindashboardComponent,
    RemoveQuestionComponent,
    StuportalComponent,
    SelectexamComponent,
    PdfGenerateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
