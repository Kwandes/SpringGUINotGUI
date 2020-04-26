/*
    Basic Service class for handling PersonRepo and Person model relations
    Will be expanded further as other Spring SQL functionality is added
 */

package fail.faisal.springExercise.Service;

import fail.faisal.springExercise.Model.Person;
import fail.faisal.springExercise.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    PersonRepo personRepo;

    public List<Person> fetchAll()
    {
        //SQL code
        return personRepo.fetchAll();
    }

    public Person findPersonByID(int id)
    {
        return personRepo.findPersonByID(id);
    }

    public Person addPerson(Person p)
    {
        return personRepo.addPerson(p);
    }

    public  Person updatePerson(int id, Person p)
    {
        return personRepo.updatePerson(id, p);
    }

    public Boolean deletePerson(int id)
    {
        return personRepo.deletePerson(id);
    }
}
