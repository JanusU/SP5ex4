/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author JanusPC
 */
public class dataGenerator {

    private boolean fname = false;
    private boolean lname = false;
    private boolean street = false;
    private boolean city = false;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String[] strarr = new String[100];

    public dataGenerator() {
        strarr[0] = "a,b,c,d";
        strarr[1] = "1,2,3,4";
    }

    public String getData(int amount, String output) {
        checker(output);
        JsonArray names = new JsonArray();
        for (int i = 0; i <= amount; i++) {
            JsonObject person = new JsonObject();
            if(fname==true) person.addProperty("fname", strarr[amount].split(",")[0]);
            if(lname==true) person.addProperty("lname", strarr[amount].split(",")[1]);
            if(street==true) person.addProperty("street", strarr[amount].split(",")[2]);
            if(city==true) person.addProperty("city", strarr[amount].split(",")[3]);
            names.add(person);
        }
        reset();
        return gson.toJson(names);
    }
    

    public void checker(String s) {
        for (int i = 0; i <= s.split(",").length; i++) {
            switch (s.split(",")[i]) {
                case "fname":
                    fname = true;
                    break;
                case "lname":
                    lname = true;
                    break;
                case "street":
                    street = true;
                    break;
                case "city":
                    city = true;
                    break;
            }
        }
    }
    public void reset() {
        fname = false;
        lname = false;
        street = false;
        city = false;
    }

}
