package b00772646assignment19.dao;

import java.util.List;
import b00772646assignment19.models.Link;

//Interface Definition
public interface LinkDao {

    //Returning A List Of All Link Objects
    public List<Link> findAll();

    //Returning A Link With Matching Id
    public Link findById(int id);

    //Returning A List Of Links Under A Topic
    public List<Link> findByTopic(int id);

    // Create a new link
    public Link create(final Link link);
}