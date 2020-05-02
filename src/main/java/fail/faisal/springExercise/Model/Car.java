package fail.faisal.springExercise.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int carID;
    private String brand;
    private String model;
    private String color;

    public Car () {

    }

    public Car ( int carID, String brand, String model, String color ) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    //region Getters & Setters
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //endregion
}
