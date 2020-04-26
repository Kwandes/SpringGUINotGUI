/*
    Basic class for interaction with the database
    Will be expanded further as other Spring SQL functionality is added
 */

package fail.faisal.springExercise.Repository;

import fail.faisal.springExercise.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Person> fetchAll()
    {
        String query = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(query, rowMapper);
    }

    public Person findPersonByID(int id)
    {
        return null;
    }

    public Person addPerson(Person p)
    {
        return null;
    }

    public  Person updatePerson(int id, Person p)
    {
        return null;
    }

    public Boolean deletePerson(int id)
    {
        return null;
    }
}
