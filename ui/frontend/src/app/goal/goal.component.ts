import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css'],
})
export class GoalComponent {
  @Input() goalTitle: String;
  @Input() goalDescription: String;
  isExpanded = false;
  constructor() {
    this.goalTitle = 'Goal Title';
    this.goalDescription = 'Goal Description';
  }

  public clickCard(): void {
    this.isExpanded = this.isExpanded ? false : true;
    console.log('Expand the card');
  }
}
