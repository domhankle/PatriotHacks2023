import { Component, Inject, Output, EventEmitter } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddGoalDialogComponent } from '../add-goal-dialog/add-goal-dialog.component';
import { GoalService } from '../goal.service';
import { Goal } from '../goal/goal';

@Component({
  selector: 'app-add-goal',
  templateUrl: './add-goal.component.html',
  styleUrls: ['./add-goal.component.css'],
})
export class AddGoalComponent {
  @Output() goalData: EventEmitter<Goal[]> = new EventEmitter<Goal[]>();
  constructor(
    private dialogService: MatDialog,
    @Inject(GoalService) private _goalService: GoalService
  ) {}

  public ngAfterViewInit(): void {
    this.emitData();
  }

  public openAddGoalDialog(): void {
    const dialogRef = this.dialogService.open(AddGoalDialogComponent, {
      disableClose: true,
      data: {},
    });

    dialogRef.afterClosed().subscribe(() => {
      this.emitData();
    });
  }

  private async emitData(): Promise<void> {
    this._goalService.getAllGoals().subscribe((data) => {
      this.goalData.emit(data);
    });
  }
}
