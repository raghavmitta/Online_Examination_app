import { RemoveQuestionComponent } from "./removequestion/removequestion.component";
import { AddquestionComponent } from "./addquestion/addquestion.component";
import { AdmindashboardComponent } from "./admindashboard/admindashboard.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { ExaminationInstructionComponent } from "./examination-instruction/examination-instruction.component";
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoadQuestionsComponent } from './load-questions/load-questions.component';
import { StuportalComponent } from './stuportal/stuportal.component';
import { SelectexamComponent } from './selectexam/selectexam.component';
import { AdminSuccessComponent } from './admin-success/admin-success.component';
import { ContactusComponent } from './contactus/contactus.component';

const routes: Routes = [
{path:'',component:HomeComponent}, 
{path:'instructions',component:ExaminationInstructionComponent},
{path:'loadquestion',component:LoadQuestionsComponent},
{path:'register',component:RegisterComponent},
{path:'login',component:LoginComponent},
{path: 'admin/admin-dashboard', component:AdmindashboardComponent},
{path: 'admin/add-question', component:AddquestionComponent},
{path: 'admin/remove-question', component:RemoveQuestionComponent},
{path: 'stuportal', component:StuportalComponent},
{path: 'selectexam', component:SelectexamComponent},
{path: 'success', component:AdminSuccessComponent},
{path: 'contactus', component:ContactusComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
