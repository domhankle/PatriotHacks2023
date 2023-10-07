import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { GoalTableComponent } from './goal-table.component';

@NgModule({
  declarations: [GoalTableComponent],
  imports: [CommonModule, MaterialModule],
  exports: [GoalTableComponent],
})
export class GoalTableModule {}
