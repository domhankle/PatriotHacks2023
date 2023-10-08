import { Component, Input, Inject } from '@angular/core';
import { ɵInjectableAnimationEngine } from '@angular/platform-browser/animations';
import { GoalService } from '../goal.service';

@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css'],
})
export class GoalComponent {
  @Input() goalTitle: String;
  @Input() goalId?: String;
  @Input() goalSteps?: String[];
  isExpanded = false;
  constructor(@Inject(GoalService) private _goalService: GoalService) {
    this.goalTitle = 'Goal Title';
  }

  public deleteCard(): void {}

  public clickCard(): void {
    this.isExpanded = this.isExpanded ? false : true;
  }

  public deleteGoal(): void {
    this._goalService;
  }
}
