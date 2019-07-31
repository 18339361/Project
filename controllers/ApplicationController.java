package b00772646assignment19.controllers;

// Import framework dependencies - required to handle the HTTP request and send a response
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.WebApplicationInitializer;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired; 
import java.util.*; 

import b00772646assignment19.models.Link; 
import b00772646assignment19.dao.LinkDao; 

import b00772646assignment19.models.Topic; 
import b00772646assignment19.dao.TopicDao; 

//The @ annotation identifies this as a Controller class
@Controller
public class ApplicationController {
    @Autowired 
    private LinkDao linkData;

    @RequestMapping(value = "/link", method = RequestMethod.GET)
    //Uses a model instance - which will be passed to a view
    public String link(Model model)
    {
      //Get the list of links from the LinkDao instance
      List<Link> link = linkData.findAll();
      model.addAttribute("link", link);
      //Return the view
      return "link";
    }

    @RequestMapping(value = "/newLink", method = RequestMethod.GET)
    public String newLink(Model model) {
      // add empty Link to the model
      model.addAttribute("link", new Link());

      // Get a list of Topics and add to the model
      List<Topic> topics = topicData.findAll();
      model.addAttribute("topics", topics);

      // Return the view
      return "newLink";
    }

    // Handle form submit via HTTP POST
    @RequestMapping(value= "/newLink", method = RequestMethod.POST)
    // Form data will be supplied as a filled in Link object
    public String createLink(Link link) {

      // Use the Dao to create the new link
      // checking for errors and returning to the form if any are found
      linkData.create(link);
      
      // Redirecting back to the links list
      // Opening a page showing the new link in its oen page
      return "redirect:/link";
    }

    @Autowired 
    private TopicDao topicData;

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    //Uses a model instance - which will be passed to a view
    public String topic(Model model)
    {
      //Get the list of topics from the TopicDao instance
      List<Topic> topic = topicData.findAll();
      model.addAttribute("topic", topic);
      return "topic";
    }

    @RequestMapping(value="/links", method = RequestMethod.GET)
    public String links(Model model,@RequestParam("id") int id)
    {
      List<Link> list = linkData.findByTopic(id);
      model.addAttribute("links", list);
      return "links";
    }
}
