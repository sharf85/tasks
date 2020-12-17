package de.telran;

public class Main {

    public static void main(String[] args) {
// time test
        String res = "";
        long beforeConcatenation = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            res += "Evgeny Borisovich";
        }
        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;
        System.out.println(timeConcatenated);

        // StringBuilder

        StringBuilder builder = new StringBuilder();
        builder.append("Evgeny")
                .append(" ")
                .append("Borisovich");

        builder.append("Evgeny");
        builder.append(" ");
        builder.append("Borisovich");

        String str = builder.toString();
        System.out.println(str);
    }
}
