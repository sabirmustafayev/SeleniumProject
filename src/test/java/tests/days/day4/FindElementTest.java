package tests.days.day4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;


public class FindElementTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");
         //finding element
        WebElement button = driver.findElement(By.id("form_submit"));
        // to click element
        button.click();
        BrowserUtils.wait(2);
        driver.close();


    }
}
