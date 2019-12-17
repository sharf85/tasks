package com.telran;

import com.telran.collection.OurList;
import com.telran.collection.OurArrayList;
import com.telran.comparator.CountryCodeComparator;
import com.telran.comparator.OurComparator;

public class Application {

    public static void main(String[] args) {

//        OurArrayList list = createListOfHumans();
//
//        Human anotherVasya = new Human("Vasily", 20);
//
//        list.remove(anotherVasya);//false
//        System.out.println(list.size());

        //example for comparator
        OurComparator countryCodeComparator = new CountryCodeComparator();
        OurArrayList countryCodes = new OurArrayList();

        fillCountryCodes(countryCodes);
        System.out.println(countryCodes.max(countryCodeComparator));
        System.out.println(countryCodes.min(countryCodeComparator));

        countryCodes.sort(countryCodeComparator);
        for (int i = 0; i < countryCodes.size(); i++) {
            System.out.println(countryCodes.get(i));
        }

    }

    private static void fillCountryCodes(OurList countryCodes) {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode israel = new CountryCode("Israel", 972);

        countryCodes.append(germany);
        countryCodes.append(israel);
        countryCodes.append(russia);
        countryCodes.append(usa);
    }

    private static OurArrayList createListOfHumans() {
        Human vasya = new Human("Vasily", 20);
        Human petya = new Human("Petr", 21);
        Human masha = new Human("Maria", 22);

        OurArrayList list = new OurArrayList();
        list.append(vasya);
        list.append(petya);
        list.append(masha);
        return list;
    }


}
