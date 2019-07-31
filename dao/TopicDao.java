package b00772646assignment19.dao;

import java.util.List;
import b00772646assignment19.models.Topic;

//Interface Definition
public interface TopicDao {

    //Returning A List Of All Link Objects
    public List<Topic> findAll();

    //Returning A Link With Matching Id
    public Topic findById(int id);
}