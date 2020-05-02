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
        String query = "SELECT * FROM person WHERE id = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p = template.queryForObject(query, rowMapper, id);
        return p;
    }

    // in Cay's video, he provides data via postmapping annotation
    public Person addPerson(Person p)
    {
        String query = "INSERT INTO person(id, first_name, last_name) VALUES (?, ?, ?)";
        template.update(query, p.getId(), p.getFirstName(), p.getLastName());
        return null;
    }

    public Person updatePerson(int id, Person p)
    {
        return null;
    }

    public Boolean deletePerson(int id)
    {
        return null;
    }
}
