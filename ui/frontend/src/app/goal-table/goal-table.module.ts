import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { GoalTableComponent } from './goal-table.component';
import { GoalComponent } from '../goal/goal.component';
import { AddGoalModule } from '../add-goal/add-goal.module';

@NgModule({
  declarations: [GoalTableComponent, GoalComponent],
  imports: [CommonModule, MaterialModule, AddGoalModule],
  exports: [GoalTableComponent, AddGoalModule],
})
export class GoalTableModule {}
