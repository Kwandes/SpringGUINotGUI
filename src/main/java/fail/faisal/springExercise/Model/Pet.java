package fail.faisal.springExercise.Model;

public class Pet {

    // region Attributes
    private String name;
    private String species;
    private int age;
    private String birthdate;
    // endregion

    // region Constructors
    public Pet () {}

    public Pet (String name, String species, int age, String birthdate) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.birthdate = birthdate;
    }
    // endregion

    // region Methods

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }


    // endregion

    // region Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    // endregion
}
