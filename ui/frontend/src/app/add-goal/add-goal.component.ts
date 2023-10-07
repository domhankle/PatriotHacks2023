import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddGoalDialogComponent } from '../add-goal-dialog/add-goal-dialog.component';

@Component({
  selector: 'app-add-goal',
  templateUrl: './add-goal.component.html',
  styleUrls: ['./add-goal.component.css'],
})
export class AddGoalComponent {
  constructor(private dialogService: MatDialog) {}

  public openAddGoalDialog(): void {
    const dialogRef = this.dialogService.open(AddGoalDialogComponent, {
      data: {},
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(result);
    });
  }
}
