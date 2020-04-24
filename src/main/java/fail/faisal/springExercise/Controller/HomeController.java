package fail.faisal.springExercise.Controller;

import fail.faisal.springExercise.Model.Pet;
import fail.faisal.springExercise.SpringExerciseApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
