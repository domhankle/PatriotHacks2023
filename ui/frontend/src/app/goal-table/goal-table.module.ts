import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { GoalTableComponent } from './goal-table.component';
import { GoalComponent } from '../goal/goal.component';

@NgModule({
  declarations: [GoalTableComponent, GoalComponent],
  imports: [CommonModule, MaterialModule],
  exports: [GoalTableComponent],
})
export class GoalTableModule {}
