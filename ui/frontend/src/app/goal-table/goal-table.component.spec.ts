import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalTableComponent } from './goal-table.component';

describe('GoalTableComponent', () => {
  let component: GoalTableComponent;
  let fixture: ComponentFixture<GoalTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GoalTableComponent]
    });
    fixture = TestBed.createComponent(GoalTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
