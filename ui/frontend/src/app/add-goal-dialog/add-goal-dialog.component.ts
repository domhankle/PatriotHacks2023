import { Component, Inject } from '@angular/core';
import { Goal } from '../goal/goal';
import { GoalService } from '../goal.service';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-goal-dialog',
  templateUrl: './add-goal-dialog.component.html',
  styleUrls: ['./add-goal-dialog.component.css'],
})
export class AddGoalDialogComponent {
  prompt: String;
  constructor(
    @Inject(GoalService) private _goalService: GoalService,
    @Inject(MatDialogRef<AddGoalDialogComponent>)
    private _dialogRef: MatDialogRef<AddGoalDialogComponent>
  ) {
    this.prompt = '';
  }

  public async createNewGoal(): Promise<void> {
    await this._goalService.addGoal(this.prompt).subscribe((response) => {
      this._dialogRef.close();
    });

    return Promise.resolve();
  }

  public cancelCreation(): void {
    this._dialogRef.close('Canceled');
  }
}
