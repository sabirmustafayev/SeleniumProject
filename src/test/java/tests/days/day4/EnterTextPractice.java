package tests.days.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("alleyezonus@gmail.com");
    }
}
