package fail.faisal.springExercise.Controller;

import fail.faisal.springExercise.Model.Car;
import fail.faisal.springExercise.Model.Person;
import fail.faisal.springExercise.Model.Pet;
import fail.faisal.springExercise.Service.CarService;
import fail.faisal.springExercise.Service.PersonService;
import fail.faisal.springExercise.SpringExerciseApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {
    private static List<Pet> petList = new ArrayList<Pet>();

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    //region Others
    @GetMapping("/inputExercise")
    public String getInputExercise()
    {
        return "home/inputExercise";
    }

    @PostMapping("/inputExercise")
    public String petData (WebRequest wr, @ModelAttribute Pet pet, Model model) {
//             (@ModelAttribute Pet pet, Model model) {
        String petName = wr.getParameter("petName");
        String petSpecies = wr.getParameter("petSpecies");
        int petAge = Integer.parseInt(Objects.requireNonNull(wr.getParameter("petAge")));
        String petBirthdate = wr.getParameter("petBirthdate");

        pet = new Pet(petName, petSpecies, petAge, petBirthdate);
        petList.add(pet);
        System.out.println();
        for (int i = 0; i < petList.size(); i ++ ) {
            System.out.println(petList.get(i).toString());
        }

        model.addAttribute("PePe", petList);

        return "home/petList";
    }

    @PostMapping("/petList")
    public String back () {
        return "home/inputExercise";
    }


    // display thingsWeDislike.html when user calls http://localhost:8088/thingsWeDislike
    @GetMapping("/thingsWeDislike")
    public String thingsWeDislike()
    {
        return "home/thingsWeDislike";
    }

    @GetMapping("/sql")
    public String sql(Model model)
    {
        List<Person> personList = personService.fetchAll();
        model.addAttribute("persons", personList);
        return "/home/sql";
    }

    //endregion

    //region Cailua
    //region Person
    @Autowired
    PersonService personService;


    @GetMapping("/person")
    public String person(Model model)
    {
        List<Person> personList = personService.fetchAll();
        model.addAttribute("personList", personList);
        return "/home/person";
    }

    @PostMapping("/addPerson")
    public String addPerson ( @ModelAttribute Person person ){
        personService.addPerson( person );
        return "redirect:/person";
    }

    @PostMapping("/deletePerson")
    public String deletePerson (WebRequest wr) {
        int personID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID")));
        Boolean deleted = personService.deletePerson(personID);
        return "redirect:/person";
    }

    @PostMapping("/editPerson")
    public String editPerson(Model model, WebRequest wr)
    {
        Person person = personService.findPersonByID(Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID"))));
        model.addAttribute("person", person);
        return "redirect:/editPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson (WebRequest wr) {
        String firstName = wr.getParameter("firstName");
        String lastName = wr.getParameter("lastName");
        int personID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("personID")));
        Person person = new Person ( personID, firstName, lastName );
        personService.updatePerson(person);
        return "redirect:/person";
    }
    //endregion

    //region Car
    @Autowired
    CarService carService;

    @GetMapping("/car")
    public String car(Model model)
    {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("carList", carList);
        return "/home/car";
    }

    @PostMapping("/addCar")
    public String addCar( @ModelAttribute Car car ) {
        carService.addCar(car);
        return "redirect:/car";
    }

    @PostMapping("/deleteCar")
    public String deleteCar (WebRequest wr) {
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        carService.deleteCar(carID);
        return "redirect:/car";
    }

    @PostMapping("/editCar")
    public String editCar(Model model, WebRequest wr)
    {
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        Car car = carService.findCarByID(carID);
        model.addAttribute("car", car);
        return "redirect:/editCar";
    }

    @PostMapping("/saveCar")
    public String saveCar (WebRequest wr){
        int carID = Integer.parseInt(Objects.requireNonNull(wr.getParameter("carID")));
        String brand = wr.getParameter("brand");
        String model = wr.getParameter("model");
        String color = wr.getParameter("color");
        Car car = new Car (carID, brand, model, color);
        carService.updateCar(car);
        return "redirect:/car";
    }
    //endregion
    //endregion
}
