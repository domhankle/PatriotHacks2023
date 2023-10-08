import { Component, Inject } from '@angular/core';
import { GoalService } from '../goal.service';
import { MatDialogRef } from '@angular/material/dialog';
import { Prompt } from '../goal/goal';

@Component({
  selector: 'app-add-goal-dialog',
  templateUrl: './add-goal-dialog.component.html',
  styleUrls: ['./add-goal-dialog.component.css'],
})
export class AddGoalDialogComponent {
  prompt: Prompt;
  constructor(
    @Inject(GoalService) private _goalService: GoalService,
    @Inject(MatDialogRef<AddGoalDialogComponent>)
    private _dialogRef: MatDialogRef<AddGoalDialogComponent>
  ) {
    this.prompt = {
      title: '',
      description: '',
    };
  }

  public async createNewGoal(): Promise<void> {
    console.log(this.prompt.title);
    console.log(this.prompt.description);
    await this._goalService.sendPrompt(this.prompt).subscribe(
      (response) => {
        this._dialogRef.close(this.prompt);
      },
      (error) => {
        console.log(error);
      }
    );
    return Promise.resolve();
  }

  public cancelCreation(): void {
    this._dialogRef.close('Canceled');
  }
}
