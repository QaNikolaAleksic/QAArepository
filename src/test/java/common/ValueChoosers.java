package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

    public static String getRandomSex() {
        ArrayList<String> listOfPosition = new ArrayList<>();
        listOfPosition.add("M");
        listOfPosition.add("F");

        return listOfPosition.get(RandomUtils.nextInt(0, listOfPosition.size()));
    }
}
