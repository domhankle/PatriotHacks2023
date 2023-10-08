import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Goal, Prompt } from './goal/goal';

@Injectable({
  providedIn: 'root',
})
export class GoalService {
  private apiURL = 'http://localhost:8080/goals';
  private currentGoals: Goal[];
  constructor(private http: HttpClient) {
    this.currentGoals = [];
  }

  public sendPrompt(prompt: Prompt): Observable<any> {
    return this.http.post<Prompt>(`${this.apiURL}/prompt`, prompt);
  }

  public getAllGoals(): Observable<any[]> {
    return this.http.get<Goal[]>(`${this.apiURL}/all`);
  }

  public setCurrentGoals(toSet: Goal[]): void {
    this.currentGoals = toSet;
  }

  public getCurrentGoals(): Goal[] {
    return this.currentGoals;
  }

  public deleteGoal(id: String): Observable<any> {
    const params = new HttpParams().set('id', id.toString());
    return this.http.delete<Goal>(`${this.apiURL}/complete`, { params });
  }
}
