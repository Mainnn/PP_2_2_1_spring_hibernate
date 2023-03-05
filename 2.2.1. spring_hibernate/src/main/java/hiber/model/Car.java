package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private int series;

    public Car() {
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car---------------" +
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


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
