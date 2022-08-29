import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';;
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterpageComponent } from './registerpage/registerpage.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { RegistrationsuccessComponent } from './registrationsuccess/registrationsuccess.component';
import { LoginComponent } from './login/login.component';
import { BookingComponent } from './booking/booking.component';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';
import { DisplayUserComponent } from './display-user/display-user.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EditThemeComponent } from './edit-theme/edit-theme.component';
import { AddthemeComponent } from './Addtheme/Addtheme.component';
import { AdminAddonComponent } from './admin-add-on/admin-add-on.component';
import { AdminfoodComponent } from './adminfood/adminfood.component';
import { UpdatefoodComponent } from './updatefood/updatefood.component';
import { UpdatethemeComponent } from './updatetheme/updatetheme.component';
import { ViewfoodComponent } from './viewfood/viewfood.component';
import { ViewthemeComponent } from './viewtheme/viewtheme.component';
import { AuthInterceptor } from './httpinterceptor';
import { UserdetailComponent } from './userdetail/userdetail.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AdminFeedbackComponent } from './admin-feedback/admin-feedback.component';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterpageComponent,
    RegistrationsuccessComponent,
    LoginComponent,
    BookingComponent,
    ViewbookingComponent,
    DisplayUserComponent,
    HomepageComponent,
    EditThemeComponent,
    AddthemeComponent,
    AdminAddonComponent,
    AdminfoodComponent,
    UpdatefoodComponent,
    UpdatethemeComponent,
    ViewfoodComponent,
    ViewthemeComponent,
    UserdetailComponent,
    FeedbackComponent,
    AdminFeedbackComponent,
    HomeComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
