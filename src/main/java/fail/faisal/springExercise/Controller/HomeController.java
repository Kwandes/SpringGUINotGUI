package fail.faisal.springExercise.Controller;

import fail.faisal.springExercise.Model.DislikedThings;
import fail.faisal.springExercise.Model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {
    private static List<Pet> petList = new ArrayList<Pet>();
    private static List<DislikedThings> dislikedThings = new ArrayList<DislikedThings>();

    @GetMapping("/")
    public String index() {
        return "home/inputExercise";
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
    public String thingsWeDislike(Model model)
    {
        // add the dislikedThings list to the model so it can be displayed
        model.addAttribute("dislikedThings", dislikedThings);
        return "home/thingsWeDislike";
    }

    @PostMapping("/addNewDislike")
    public RedirectView addNewDislike(WebRequest wr, @ModelAttribute DislikedThings dislikedThing, Model model)
    {
        dislikedThing =  new DislikedThings(wr.getParameter("dislikeName"), wr.getParameter("author"));
        dislikedThings.add(dislikedThing);
        model.addAttribute("dislikedThings", dislikedThings);
        System.out.println("Added new disliked thing: " + dislikedThing.getName() + ", author: " + dislikedThing.getAuthor());

        /*
            While the default value for the "contextRelative" flag is off,
            you will probably want to almost always set it to true.
            With the flag off, URLs starting with "/" are considered relative to the web server root,
            while with the flag on, they are considered relative to the web application root.

            Since most web applications will never know or care what their context path actually is,
            they are much better off setting this flag to true, and submitting paths which are to be considered relative
            to the web application root.
        */
        return new RedirectView("/thingsWeDislike", true);
    }

}
