package backend.components;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DynamoDB {

    

    public static void putItemInTable(DynamoDbClient ddb, String tableName, String id, String title, List<String> steps)
    {   
        HashMap<String,AttributeValue> itemValues = new HashMap<>();
        itemValues.put("goal_id", AttributeValue.builder().s(id).build());
        // itemValues.put("advice", AttributeValue.builder().s(advice).build());
        itemValues.put("title", AttributeValue.builder().s(title).build());

        List<AttributeValue> attSteps = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            attSteps.add(AttributeValue.builder().s(steps.get(i)).build());
        }
        itemValues.put("steps", AttributeValue.builder().l(attSteps).build());


        PutItemRequest request = PutItemRequest.builder()
            .tableName(tableName)
            .item(itemValues)
            .build();

        try {
            PutItemResponse response = ddb.putItem(request);
            System.out.println(tableName +" was successfully updated. The request id is "+response.responseMetadata().requestId());

        } catch (ResourceNotFoundException e) {
            System.err.format("Error: The Amazon DynamoDB table \"%s\" can't be found.\n", tableName);
            System.err.println("Be sure that it exists and that you've typed its name correctly!");
            System.exit(1);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static Map<String, AttributeValue> getDynamoDBItem(DynamoDbClient ddb, String tableName, String id, List<String> advice ) {
       
        HashMap<String,AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("goal_id", AttributeValue.builder()
            .s(id)
            .build());

        GetItemRequest request = GetItemRequest.builder()
            .key(keyToGet)
            .tableName(tableName)
            .build();

        try {
            // If there is no matching item, GetItem does not return any data.
            Map<String,AttributeValue> returnedItem = ddb.getItem(request).item();
            
            return returnedItem;

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }

    public static List<Map<String, AttributeValue>> scanItems(DynamoDbClient ddb, String tableName) {

        try {
            ScanRequest request = ScanRequest.builder()
                .tableName(tableName)
                .build();
            
            ScanResponse response = ddb.scan(request);

            return response.items();
            
        }
        catch(DynamoDbException e)
        {
            System.out.println(e);
            System.exit(1);
            return null;
        }
    }

    public static void deleteDynamoDbItem(DynamoDbClient ddb, String tableName, String id) {
        HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("goal_id", AttributeValue.builder()
            .s(id)
            .build());

        DeleteItemRequest deleteReq = DeleteItemRequest.builder()
            .tableName(tableName)
            .key(keyToGet)
            .build();

        try {
            ddb.deleteItem(deleteReq);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
