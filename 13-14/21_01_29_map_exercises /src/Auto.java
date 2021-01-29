public class Auto {

    private String make;
    private String color;

    public Auto(String make, String color) {
        this.color = color;
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }
}
