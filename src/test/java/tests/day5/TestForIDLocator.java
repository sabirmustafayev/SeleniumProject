package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForIDLocator {
    /*
        webElement represents any kind of element within a webPage. This could be a header, locator, button etc.

        There are 8 locators to find an element in a website:
            ID --> best way to find an element, quick and unique. But not always available
     */

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement locate =driver.findElement(By.id("disappearing_button"));
        locate.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        driver.close();



    }
}
