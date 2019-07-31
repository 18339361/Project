package b00772646assignment19.dao.implementation;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
// import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import b00772646assignment19.dao.TopicDao;
import b00772646assignment19.models.Topic;

@Repository
public class TopicDaoImpl implements TopicDao {

    //SQL for selecting Topics
    private final String SELECT_SQL = "SELECT * FROM dbo.Topic";
    private final String SELECT_SQL_BY_ID = "SELECT *FROM dbo.Topic WHERE TopicId = ?";

    //Spring JdbcTemplate helps with storing and retrieving data
    @Autowired
    private JdbcTemplate jdbctemplate;

    //Implement findAll() which retrieves all topics from the DB
    //TopicMapper() converts rows from the result into topic objects
    public List<Topic> findAll() {
        return jdbctemplate.query(SELECT_SQL, new TopicMapper());
    }

    //Return the topic with matching id
    public Topic findById(int id) {
        return jdbctemplate.queryForObject(SELECT_SQL_BY_ID, new Object[] { id }, new TopicMapper());
    }
}

//This class converts resulting rows into jaba objects
class TopicMapper implements RowMapper<Topic> {
    @Override
    public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topic t= new Topic();
        t.setTopicId(rs.getInt("TopicId"));
        t.setTopicName(rs.getString("TopicName"));
        return t;
    }
}