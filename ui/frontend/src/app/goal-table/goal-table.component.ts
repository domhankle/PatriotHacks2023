import { Component } from '@angular/core';
import { Goal } from '../goal/goal';

@Component({
  selector: 'app-goal-table',
  templateUrl: './goal-table.component.html',
  styleUrls: ['./goal-table.component.css'],
})
export class GoalTableComponent {
  currentGoals: Goal[];

  constructor() {
    this.currentGoals = [];
  }

  generateGoals() {
    
  }
}
