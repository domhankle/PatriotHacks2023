package backend.components;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println(this.toString());
    }

    public Goal(Map<String, AttributeValue> item) {
        this.id = item.get("goal_id").s();
        this.title = item.get("title").s();
        List<AttributeValue> list = item.get("steps").l();
        this.steps = new ArrayList<String>();
        for (int i = 0; i<list.size(); i++) {
            steps.add(list.get(i).s());
        }
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

        if (!Character.isDigit(advice.trim().charAt(0))) {
            steps.remove(0);
        }

        if (steps.get(0).trim().isEmpty()) {
            steps.remove(0);
        }

        if (steps.get(0).trim().charAt(0) == '.') {
            for (int i = 0; i<steps.size(); i++) {
                String newStep = steps.get(i);
                steps.set(i, steps.get(i).replaceFirst(".", "").trim());
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("id: ").append(id).append("\ntitle: ").append(title).append("\nadvice:\n").append(advice).append("\n").append(steps).toString();
    }

    


}
