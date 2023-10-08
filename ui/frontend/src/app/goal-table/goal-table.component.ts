import { Component, Inject } from '@angular/core';
import { Goal } from '../goal/goal';
import { GoalService } from '../goal.service';

@Component({
  selector: 'app-goal-table',
  templateUrl: './goal-table.component.html',
  styleUrls: ['./goal-table.component.css'],
})
export class GoalTableComponent {
  currentGoals: Goal[];

  constructor(@Inject(GoalService) private _goalService: GoalService) {
    this.currentGoals = [];
  }

  public handleGoalsEvent(eventData: Goal[]): void {
    this.currentGoals = [];
    eventData.forEach((goal) => {
      this.currentGoals.push({
        id: goal.id,
        title: goal.title,
        steps: goal.steps,
      });
    });
  }
}
