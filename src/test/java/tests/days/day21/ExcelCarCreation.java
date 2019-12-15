package tests.days.day21;

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class ExcelCarCreation {

    @Test
    public void test1(){
        ExcelUtil cars = new ExcelUtil("/Users/Emrullah/Downloads/CreateCarData.xlsx","Sheet1" );
        System.out.println(cars.getDataList());

        //get(0) means get data from first row
        // get("Color") means get value of Color Column from first row
        String color = cars.getDataList().get(0).get("Color");
        System.out.println(color);
        String driverName = cars.getDataList().get(0).get("Driver");
        System.out.println(driverName);

        Map<String, String> row = new HashMap<>();
        row.put("License Plate", "777");
        row.put("Driver","SDET Driver");
        System.out.println(row.get("Driver"));

        Map<Integer, String> values = new HashMap<>();
        values.put(1, "apple");
        values.put(2,"orange");
        System.out.println(values.get(1));

        Map<String, String> countryCodes = new HashMap<>();
        countryCodes.put("USA", "+1");
        countryCodes.put("Australia", "+036");
        countryCodes.put("China", "+85");
        countryCodes.put("Kazakhstan", "+7");
        countryCodes.put("Ukraine", "+380");
        countryCodes.put("South Korea", "+82");
        countryCodes.put("Turkey", "+90");
        countryCodes.put("Uzbekistan", "+998");
        countryCodes.put("Azerbaijan", "+993");

        System.out.println(countryCodes.get("USA"));
    }
}
