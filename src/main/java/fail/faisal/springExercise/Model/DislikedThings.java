package fail.faisal.springExercise.Model;

public class DislikedThings
{
    private String name;
    private String author;

    public DislikedThings()
    {
        this.name = "Life";
        this.author = "N/A";
    }

    public DislikedThings(String name)
    {
        this.name = name;
        this.author = "N/A";
    }

    public DislikedThings(String name, String author)
    {
        this.name = name;
        this.author = author.isBlank() ? "N/A" : author ;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
