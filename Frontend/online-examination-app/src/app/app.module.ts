import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExaminationInstructionComponent } from './examination-instruction/examination-instruction.component';
import { LoadQuestionsComponent } from './load-questions/load-questions.component';
import {FormsModule} from '@angular/forms'
import { HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ExaminationInstructionComponent,
    LoadQuestionsComponent
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
