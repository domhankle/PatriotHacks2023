package backend.components;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class GoalItems {
    private String prompt;
    private String id;

    public GoalItems()
    {
        this.prompt = "";
        this.id = "";
    }

    public String getPrompt()
    {
        return this.prompt;
    }

    public void setPrompt(String str)
    {
        this.prompt = str;
    }

    @DynamoDbPartitionKey
    public String getId()
    {
        return this.id;
    }

    public void setId(String str)
    {
        this.id = str;
    }


}
