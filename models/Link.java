package b00772646assignment19.models;

import java.sql.Date;

public class Link {

    //Properties
    private int TopicId;
    private int LinkId;
    private Date RecordDate;
    private String LinkName;
    private String LinkDescription;
    private String LinkURL;
    private String Notes;

    //Constructors
    public Link() {

    }

    public Link(int TopicId, int LinkId, Date RecordDate, String LinkName, String LinkDescription, String LinkURL, String Notes) {
        this.TopicId= TopicId;
        this.LinkId= LinkId;
        this.RecordDate= RecordDate;
        this.LinkName= LinkName;
        this.LinkDescription= LinkDescription;
        this.LinkURL= LinkURL;
        this.Notes= Notes;
    }

    //Accessor Methods 
    public int getTopicId() {
        return this.TopicId;
    }

    public void setTopicId(int TopicId) {
        this.TopicId= TopicId;
    }

    public int getLinkId() {
        return this.LinkId;
    }

    public void setLinkId(int LinkId) {
        this.LinkId= LinkId;
    }

    public Date getRecordDate() {
        return this.RecordDate;
    }

    public void setRecordDate(Date RecordDate) {
        this.RecordDate= RecordDate;
    }

    public String getLinkName() {
        return this.LinkName;
    }

    public void setLinkName(String LinkName) {
        this.LinkName= LinkName;
    }

    public String getLinkDescription() {
        return this.LinkDescription;
    }

    public void setLinkDescription(String LinkDescription) {
        this.LinkDescription= LinkDescription;
    }

    public String getLinkURL() {
        return this.LinkURL;
    }

    public void setLinkURL(String LinkURL) {
        this.LinkURL= LinkURL;
    }

    public String getNotes() {
        return this.Notes;
    }
    
    public void setNotes(String Notes) {
        this.Notes= Notes;
    }

}