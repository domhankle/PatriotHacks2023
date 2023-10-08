import { Component, Input, Inject, Output, EventEmitter } from '@angular/core';
import { Goal } from './goal';
import { GoalService } from '../goal.service';

@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css'],
})
export class GoalComponent {
  @Input() goalTitle: String;
  @Input() goalId!: String;
  @Input() goalSteps!: String[];

  @Output() goalData: EventEmitter<Goal[]> = new EventEmitter<Goal[]>();
  isExpanded = false;
  constructor(@Inject(GoalService) private _goalService: GoalService) {
    this.goalTitle = 'Goal Title';
  }

  public deleteCard(): void {}

  public clickCard(): void {
    this.isExpanded = this.isExpanded ? false : true;
  }

  public deleteGoal(): void {
    this._goalService.deleteGoal(this.goalId!).subscribe((response) => {
      this._goalService.getAllGoals().subscribe((data) => {
        this.goalData!.emit(data);
      });
    });
  }
}
