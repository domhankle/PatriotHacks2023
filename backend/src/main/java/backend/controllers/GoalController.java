package backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;

import backend.components.DynamoDB;
import backend.components.Goal;
import backend.components.Prompt;

import java.util.Map;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/goals")
public class GoalController {
    private DynamoDbClient ddb;

    @Autowired
    public GoalController(){
        Region region = Region.US_EAST_1;
        this.ddb = DynamoDbClient.builder()
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .region(region)
            .build();   
    }

    @PostMapping("/prompt")
    void processPrompt(@RequestBody Prompt prompt) {
        System.out.println(prompt);
    }

    @GetMapping("/all")
    ArrayList<Goal> getAll() {
        ArrayList<Map<String, AttributeValue>> rawData = DynamoDB.scanItems(ddb, "Goals");
        ArrayList<Goal> goals = new ArrayList<>();

        for(Map<String, AttributeValue> item : rawData) {
            goals.add(new Goal(item));
        }

        return goals;
    }
    
}
