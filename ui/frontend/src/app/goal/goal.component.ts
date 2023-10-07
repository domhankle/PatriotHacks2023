import { Component } from '@angular/core';

@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css'],
})
export class GoalComponent {
  goalTitle: String;
  goalDescription: String;
  constructor() {
    this.goalTitle = 'Goal Title';
    this.goalDescription = 'Goal Description';
  }
}
