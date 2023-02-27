package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    public Car() {
    }

    @Id @GeneratedValue
    private int id;

    private String model;
    private int series;


    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car---------------" +
                "\nId= " + id +
                "\nModel='" + model + '\'' +
                "\nSeries= " + series ;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getId() {
        return id;
    }

}
