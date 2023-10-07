import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddGoalComponent } from './add-goal.component';
import { AddGoalDialogComponent } from '../add-goal-dialog/add-goal-dialog.component';
import { MaterialModule } from '../material/material.module';

@NgModule({
  declarations: [AddGoalComponent, AddGoalDialogComponent],
  imports: [CommonModule, MaterialModule],
  exports: [AddGoalComponent],
})
export class AddGoalModule {}
