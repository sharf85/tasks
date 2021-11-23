package de.telran;

public class Main {

    public static void main(String[] args) {
        Auto[] autos = getAutopark();

        Auto bentley = new Auto("Bentley", 2010, "Silver");

        System.out.println(containsAuto(autos, bentley));//true

        System.out.println(bentley);

        String descr = "The description of bentley: " + bentley;
        System.out.println(descr);
    }

    static boolean containsAuto(Auto[] autos, Auto auto) {
        for (int i = 0; i < autos.length; i++) {
            if (autos[i].equals(auto))
                return true;
        }
        return false;
    }

    private static Auto[] getAutopark() {
        Auto opel = new Auto("Opel", 2012, "Grey");
        Auto mazda = new Auto("Mazda", 2015, "Red");
        Auto bentley = new Auto("Bentley", 2010, "Silver");

        return new Auto[]{opel, mazda, bentley};
    }


}
