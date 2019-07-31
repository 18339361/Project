package b00772646assignment19.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import b00772646assignment19.dao.LinkDao;
import b00772646assignment19.models.Link;

@Repository
public class LinkDaoImpl implements LinkDao {

    //SQL for selecting Links
    private final String SELECT_SQL = "SELECT * FROM dbo.Link";
    private final String SELECT_SQL_BY_ID = "SELECT *FROM dbo.Link WHERE LinkId = ?";
    private final String SELECT_SQL_BY_TOPIC_ID = "SELECT * FROM dbo.Link WHERE TopicId = ?";
    private final String INSERT_SQL = "INSERT INTO Link values(?,?,?,?,?,?,?)";

    //Spring JdbcTemplate helps with storing and retrieving data
    @Autowired
    private JdbcTemplate jdbctemplate;

    //Implement findAll() which retrieves all links from the DB
    //LinkMapper() converts rows from the result into link objects
    public List<Link> findAll() {
        return jdbctemplate.query(SELECT_SQL, new LinkMapper());
    }

    //Return the link with matching id
    public Link findById(int id) {
        return jdbctemplate.queryForObject(SELECT_SQL_BY_ID, new Object[] { id }, new LinkMapper());
    }

    //return links for particular topics
    public List<Link> findByTopic(int id) {
        return jdbctemplate.query(SELECT_SQL_BY_TOPIC_ID, new Object[] { id }, new LinkMapper());
    }

    /* NOT SURE IF THIS IS RIGHT!!! */
    // return new link
    public List<Link> newInsert(int id) {
        return jdbctemplate.query(INSERT_SQL, new Object[] {id}, new LinkMapper());
    }
}

//This class converts resulting rows into jaba objects
class LinkMapper implements RowMapper<Link> {
    @Override
    public Link mapRow(ResultSet rs, int rowNum) throws SQLException {
        Link l= new Link();
        l.setLinkId(rs.getInt("LinkId"));
        l.setTopicId(rs.getInt("TopicId"));
        l.setRecordDate(rs.getDate("RecordDate"));
        l.setLinkName(rs.getString("LinkName"));
        l.setLinkDescription(rs.getString("LinkDescription"));
        l.setLinkURL(rs.getString("LinkURL"));
        l.setNotes(rs.getString("Notes"));
        return l;
    }


// Create a new link
public Link create(final Link link)
{
    jdbcTemplate.update(new PreparedStatementCreator() {
    // Prepared statement replaces ? parameters with values
    // Create the statement and connect
    @Override
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL); 
        //Set each parameter by index of ? in SQL and value
        ps.setInt(0, link.getLinkId());
        ps.setInt(1, link.getTopicId());
        ps.setDate(2, link.getRecordDate());
        ps.setString(3, link.getLinkName());
        ps.setString(4, link.getLinkDescription());
        ps.setString(5, link.getLinkURL());
        ps.setString(6, link.getNotes());
        //return the completed statement
        return ps;
    }
    });
    // return the newly created link
    return link;
}
}