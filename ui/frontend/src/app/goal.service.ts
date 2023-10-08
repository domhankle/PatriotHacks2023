import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Goal, Prompt } from './goal/goal';

@Injectable({
  providedIn: 'root',
})
export class GoalService {
  private apiURL = 'http://localhost:8080/goals';
  constructor(private http: HttpClient) {}

  public sendPrompt(prompt: Prompt): Observable<any> {
    return this.http.post<Goal>(`${this.apiURL}/prompt`, prompt);
  }
}
