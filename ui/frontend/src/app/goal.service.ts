import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Goal } from './goal/goal';

@Injectable({
  providedIn: 'root',
})
export class GoalService {
  private apiURL = 'http://localhost:8080/goals';
  constructor(private http: HttpClient) {}

  public addGoal(prompt: String): Observable<any> {
    return this.http.post<Goal>(`${this.apiURL}/prompt`, prompt);
  }
}
