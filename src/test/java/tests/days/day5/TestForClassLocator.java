package tests.days.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestForClassLocator {
    public static void main(String[] args) {
        WebDriver driver  = BrowserFactory.getDriver("chrome");
        driver.get("https:practice.cybertekschool.com/multiple_buttons");
        System.out.println(driver.findElement(By.className("h3")).getText());


        driver.quit();


    }
}
