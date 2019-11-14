package tests.HW.BasicNavigationHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;


public class TestCaseTwo {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

       int count = driver.findElements(By.className("list-group-item")).size();
        System.out.println("Count: " +count);
        if(count==48){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        driver.close();
    }
}
