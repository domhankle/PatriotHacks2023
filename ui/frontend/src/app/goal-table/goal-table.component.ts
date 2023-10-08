import { Component, Inject } from '@angular/core';
import { Goal } from '../goal/goal';
import { GoalService } from '../goal.service';
import { GoalComponent } from '../goal/goal.component';

@Component({
  selector: 'app-goal-table',
  templateUrl: './goal-table.component.html',
  styleUrls: ['./goal-table.component.css'],
})
export class GoalTableComponent {
  currentGoals: Goal[];

  constructor(@Inject(GoalService) public goalService: GoalService) {
    this.currentGoals = [];
  }

  public handleGoalsEvent(eventData: Goal[]): void {
    this.currentGoals = [];
    eventData.forEach((goal) =>
      this.currentGoals.push({
        title: goal.title,
        description: goal.description,
        steps: [],
      })
    );
  }
}
