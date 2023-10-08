export interface Goal {
  id: String;
  title: String;
  description: String;
  steps: GoalStep[];
}

export interface GoalStep {
  description: String;
}

export interface Prompt {
  title: String;
  description: String;
}
