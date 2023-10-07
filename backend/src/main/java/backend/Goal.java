import java.util.ArrayList;

public class Goal {
    
    private String name;

    private String prompt;

    private String advice;

    private ArrayList<String> steps;

    public Goal(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        advice = "";
        steps = new String[];
    }

    public String getName() {
        return name;
    }

    public String getPrompt() {
        return prompt;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public boolean generateAdvice() {
        return false;
    }




}