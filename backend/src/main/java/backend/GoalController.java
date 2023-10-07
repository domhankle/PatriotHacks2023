package backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;


@RestController
@RequestMapping("/goals")
public class GoalController {

    @PostMapping("/prompt")
    void processPrompt(String prompt) {
        // Replace these with your AWS access key ID and secret access key
        String accessKey = "ASIA5DREFSPAVSAHE66Z";
        String secretKey = "36YW4CwpCKwDhEYjridF93FZYPaXKLtaito5lFhp";
        
        // Specify the AWS region where your DynamoDB table is located
        Region region = Region.US_EAST_1;  // Change to your desired region
        
        // Create AWS credentials from your access key and secret key
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);
        
        // Initialize the DynamoDB client with credentials and region
        DynamoDbClient dynamoDb = DynamoDbClient.builder()
            .region(region)
            .credentialsProvider(() -> awsCredentials)
            .build();
        
        // Now you can use 'dynamoDb' to interact with your DynamoDB table
        
        PutItemResponse response = dynamoDb.putItem(
        PutItemRequest.builder()
        .tableName("Goals") // Replace with your table name
        .item(Map.of(
            "goal_id", AttributeValue.builder().s(0).build(),
            "description", AttributeValue.builder().s("Be good at disc").build(),
            "due_date", AttributeValue.builder().s("2023-12-31").build(),
            "owner", AttributeValue.builder().s("DomHankle").build(),
            "status", AttributeValue.builder().s("In Progress").build()
        ))
        .build()
);
        
        // Be sure to close the DynamoDB client when done
        dynamoDb.close();
    }

    
}
