import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String... args) {
        Car mazda = new Car("Mazda", 2000, 5000);
        Car opel = new Car("Opel", 2010, 1000);
        Car vw = new Car("VW", 2015, 1500);
        Car tesla = new Car("Tesla", 2007, 100);
        Car mercedes = new Car("Mercedes", 2021, 1700);

        List<Car> cars = Arrays.asList(mazda, opel, vw, tesla, mercedes);

        //sorting by millage
        cars.sort(new MillageComparator());
        System.out.println(cars.toString());

        // sorting by years of manufacture
        cars.sort(new YearComparator());
        System.out.println(cars.toString());

    }
}
