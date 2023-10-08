package backend.components;

import java.util.ArrayList;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class Goal {
    
    private String id;
    private String title;
    private String advice;
    private ArrayList<String> steps;

    public Goal(String id, String title, String advice) {
        this.id = id;
        this.title = title;
        this.advice = advice;
        this.steps = new ArrayList<String>();
    }

    public Goal(Map<String, AttributeValue> item) {
        this.id = item.get("goal_id");
        this.title = item.get("title");
        this.advice = item.get("advice");
        this.steps = new ArrayList<String>();
    }

    public Goal() {
        this("", "", "");
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    private boolean processSteps() {
        return false;
    }




}
