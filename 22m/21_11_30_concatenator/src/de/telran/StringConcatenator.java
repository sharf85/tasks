package de.telran;

public class StringConcatenator implements IConcatenator {
    @Override
    public String concatenate(String[] strings) {
        String res = "";

        for (int i = 0; i < strings.length; i++) {
            res = res + strings[i];
//            res += strings[i];
//            res = res.concat(strings[i]);
        }

        return res;
    }
}
