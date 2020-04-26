/*
    Basic class for interaction with the database
    Will be expanded further as other Spring SQL functionality is added
 */

package fail.faisal.springExercise.Repository;

import fail.faisal.springExercise.Model.Person;
import java.util.List;

public class PersonRepo
{
    public List<Person> fetchAll()
    {
        //SQL code
        return null; // temp return value which allows the code to compile
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
