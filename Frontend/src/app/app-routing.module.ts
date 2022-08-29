import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthguardGuard } from './authguard.guard';
import { BookingComponent } from './booking/booking.component';
import { DisplayUserComponent } from './display-user/display-user.component';
import { LoginComponent } from './login/login.component';
import { RegisterpageComponent } from './registerpage/registerpage.component';
import { RegistrationsuccessComponent } from './registrationsuccess/registrationsuccess.component';

import { ViewbookingComponent } from './viewbooking/viewbooking.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EditThemeComponent } from './edit-theme/edit-theme.component';
import { AddthemeComponent } from './Addtheme/Addtheme.component';
import { AdminAddonComponent } from './admin-add-on/admin-add-on.component';
import { AdminfoodComponent } from './adminfood/adminfood.component';
import { UpdatefoodComponent } from './updatefood/updatefood.component';
import { UpdatethemeComponent } from './updatetheme/updatetheme.component';
import { ViewfoodComponent } from './viewfood/viewfood.component';
import { ViewthemeComponent } from './viewtheme/viewtheme.component';
import { UserdetailComponent } from './userdetail/userdetail.component';
import { AdminFeedbackComponent } from './admin-feedback/admin-feedback.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'login', component: LoginComponent },
  {path: 'registration', component: RegisterpageComponent },
  {path: 'registrationsuccess', component: RegistrationsuccessComponent },
  {path: 'userhomepage', component: HomepageComponent , canActivate:[AuthguardGuard]},
  {path: 'viewbooking', component: ViewbookingComponent , canActivate:[AuthguardGuard]},
  {path: 'displayuser',component:DisplayUserComponent,canActivate:[AuthguardGuard]},
  {path:'bookevent/:themeid',component:BookingComponent,canActivate:[AuthguardGuard]},
  {path: 'editEvent/:eventId', component: EditThemeComponent, canActivate:[AuthguardGuard] },
  {path:'addtheme',component:AddthemeComponent,canActivate:[AuthguardGuard]},
  {path:'addonrouter',component:AdminAddonComponent,canActivate:[AuthguardGuard]},
  {path:'adminfood',component:AdminfoodComponent,canActivate:[AuthguardGuard]},
  {path:'updatefood/:id',component:UpdatefoodComponent,canActivate:[AuthguardGuard]},
  {path:'updatetheme/:themeid',component:UpdatethemeComponent,canActivate:[AuthguardGuard]},
  {path:'viewfood',component:ViewfoodComponent,canActivate:[AuthguardGuard]},
  {path:'viewtheme',component:ViewthemeComponent,canActivate:[AuthguardGuard]},
  {path:'userdetail',component:UserdetailComponent,canActivate:[AuthguardGuard]},
  {path:'viewfeedback',component:AdminFeedbackComponent},
  {path:'feedback',component:FeedbackComponent}
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
}) 
export class AppRoutingModule { }
