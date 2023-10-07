import { Component, Inject } from '@angular/core';
import { Goal } from '../goal/goal';
import { GoalService } from '../goal.service';

@Component({
  selector: 'app-add-goal-dialog',
  templateUrl: './add-goal-dialog.component.html',
  styleUrls: ['./add-goal-dialog.component.css'],
})
export class AddGoalDialogComponent {
  prompt: String;
  constructor(@Inject(GoalService) private _goalService: GoalService) {
    this.prompt = 'testPrompt';
  }

  public createNewGoal(): void {
    this._goalService.addGoal(this.prompt).subscribe((response) => {
      console.log('Response from server', response);
    });
  }
}
