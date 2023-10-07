export interface Goal {
  title: String;
  description: String;
  steps: GoalStep[];
}

export interface GoalStep {
  description: String;
}
