import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddGoalModule } from './add-goal/add-goal.module';
import { HeaderModule } from './header/header.module';
import { GoalTableModule } from './goal-table/goal-table.module';
import { GoalService } from './goal.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AddGoalModule,
    HeaderModule,
    GoalTableModule,
    HttpClientModule,
  ],
  providers: [GoalService],
  bootstrap: [AppComponent],
})
export class AppModule {}
