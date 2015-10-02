package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private Random r;
    private String[] fNames;
    private String[] lNames;
    private String[] streets;
    private String[] cities;

    public DataGenerator() {
        this.r = new Random();
        fNames = new String[]{"Bo", "Hans", "Benny"};
        lNames = new String[]{"Hansen", "Jensen", "Petersen"};
        streets = new String[]{"Fraugde-Vej", "Morbærhaven", "Fraugde-Kærby-Vej"};
        cities = new String[]{"København", "Odense", "Aalborg", "Alberslund"};
    }

    public String getData(int times, String data) {

        String[] dataArr = data.trim().split(",");
        List<JsonObject> list = new ArrayList();
        for (int i = 0; i < times; i++) {
            JsonObject obj = new JsonObject();
            for (int j = 0; j < dataArr.length; j++) {
                switch (dataArr[j]) {
                    case "fname":
                        obj.addProperty("fname", fNames[r.nextInt(fNames.length)]);
                        break;
                    case "lname":
                        obj.addProperty("lname", lNames[r.nextInt(lNames.length)]);
                        break;
                    case "street":
                        obj.addProperty("street", streets[r.nextInt(streets.length)]);
                        break;
                    case "city":
                        obj.addProperty("city", cities[r.nextInt(cities.length)]);
                        break;
                }
            }
            list.add(obj);
        }

        return new Gson().toJson(list);
    }
}
