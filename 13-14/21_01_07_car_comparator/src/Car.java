public class Car {
    String make;
    int yearManufacture;
    int millage;

    public Car(String make, int yearManufacture, int millage) {
        this.make = make;
        this.yearManufacture = yearManufacture;
        this.millage = millage;
    }

    public String getMake() {
        return make;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public int getMillage() {
        return millage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", millage=" + millage +
                '}';
    }
}
