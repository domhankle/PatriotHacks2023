import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddGoalModule } from './add-goal/add-goal.module';
import { HeaderModule } from './header/header.module';
import { GoalTableComponent } from './goal-table/goal-table.component';
import { GoalTableModule } from './goal-table/goal-table.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AddGoalModule,
    HeaderModule,
    GoalTableModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
