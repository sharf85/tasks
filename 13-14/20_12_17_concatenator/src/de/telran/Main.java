package de.telran;

import de.telran.concatenator.StringBufferConcatenator;
import de.telran.concatenator.StringBuilderConcatenator;
import de.telran.concatenator.StringConcatenator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
// time test
//        String res = "";
//        long beforeConcatenation = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            res += "Evgeny Borisovich";
//        }
//        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;
//        System.out.println(timeConcatenated);
//
//        List<String> strings = new ArrayList<>();
//        strings.toArray();


        // StringBuilder

//        StringBuilder builder = new StringBuilder();
//        builder.append("Evgeny")
//                .append(" ")
//                .append("Borisovich");
//
//        builder.append("Evgeny");
//        builder.append(" ");
//        builder.append("Borisovich");
//
//        String str = builder.toString();
//        System.out.println(str);

        IConcatenator stringConcatenator = new StringConcatenator();
        IConcatenator stringBuilderConcatenator = new StringBuilderConcatenator();
        IConcatenator stringBufferConcatenator = new StringBufferConcatenator();

        ConcatenationTest test;
        //string test
        test = new ConcatenationTest(stringConcatenator);
        test.test(100000, "Evgeny Borisovich");
        //string builder test
        test = new ConcatenationTest(stringBuilderConcatenator);
        test.test(10000000, "Evgeny Borisovich");
        //string buffer test
        test = new ConcatenationTest(stringBufferConcatenator);
        test.test(10000000, "Evgeny Borisovich");
    }
}
