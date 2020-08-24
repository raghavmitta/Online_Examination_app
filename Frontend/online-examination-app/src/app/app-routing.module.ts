import { ExaminationInstructionComponent } from "./examination-instruction/examination-instruction.component";
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoadQuestionsComponent } from './load-questions/load-questions.component';

const routes: Routes = [
{path:'instructions',component:ExaminationInstructionComponent},
{path:'loadquestion',component:LoadQuestionsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
