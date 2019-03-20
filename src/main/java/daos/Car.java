package daos;

public class Car implements DTO {

    private int id;
    private String make;
    private String model;
    private String year;
    private String color;
    private String vin;

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }



    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return this.id + " " + this.make + " " + this.model + " " + this.year+ " " + this.color+ " " + this.vin+"\n";
    }
}
