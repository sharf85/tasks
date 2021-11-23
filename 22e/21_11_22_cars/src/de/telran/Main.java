package de.telran;

public class Main {

    public static void main(String[] args) {
        Auto[] autos = createAutopark();

        Auto silverBentley = new Auto("Bentley", 2018, "Silver");

        System.out.println(silverBentley);

        String something = "Something " + silverBentley;

        System.out.println(something);

        System.out.println(autoparkContains(autos, silverBentley));//
    }

    static boolean autoparkContains(Auto[] autopark, Auto auto) {
        for (int i = 0; i < autopark.length; i++) {
            if (autopark[i].equals(auto))
                return true;
        }
        return false;
    }

    static Auto[] createAutopark() {
        Auto greyOpel = new Auto("Opel", 2012, "Grey");
        Auto redMazda = new Auto("Mazda", 2015, "Red");
        Auto silverBentley = new Auto("Bentley", 2018, "Silver");
        return new Auto[]{greyOpel, redMazda, silverBentley};
    }
}
