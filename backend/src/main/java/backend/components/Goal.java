package backend.components;

import java.util.ArrayList;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

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
        this.processSteps();
    }

    public Goal(Map<String, AttributeValue> item) {
        this.id = item.get("goal_id").s();
        this.title = item.get("title").s();
        this.advice = item.get("advice").s();
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
    
    public String getAdvice(){
        return this.advice;
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

    private void processSteps() {
        String[] parts = advice.split("\\d+");

        for(String part : parts)
        {
            this.steps.add(part);
        }

    }

    


}
