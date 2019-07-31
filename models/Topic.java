package b00772646assignment19.models;

public class Topic {

    //Properties
    private int TopicId;
    private String TopicName;

    //Constructors
    public Topic(){

    }

    public Topic(int TopicId, String TopicName){
        this.TopicId= TopicId;
        this.TopicName= TopicName;
    }

    //Accessor Methods
    public int getTopicId() {
        return this.TopicId;
    }

    public void setTopicId(int TopicId){
        this.TopicId = TopicId;
    }

    public String getTopicName() {
        return this.TopicName;
    }

    public void setTopicName(String TopicName) {
        this.TopicName = TopicName;
    }
}


