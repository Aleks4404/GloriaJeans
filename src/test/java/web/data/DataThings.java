package web.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataThings {

    public static String getThings() {
        return "шорты";
    }

    public static String getInvalideThings() {
        List<String> list = Arrays.asList("Капуста", "Велосипед", "Телевизор", "Холодильник", " Салфетка");
        Random rand = new Random();
        String city = list.get(rand.nextInt(list.size()));
        return city;
    }

    public static String getSpecialСharacters() {
        List<String> list = Arrays.asList("123456789", "FDGSHFN", "hfghfhf", "АААИАЕОЮЗБ", "мообарюлр", "!№;%:?");
        Random rand = new Random();
        String city = list.get(rand.nextInt(list.size()));
        return city;
    }


}
