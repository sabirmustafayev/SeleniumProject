package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForLInkText {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Asi Cocuk");
        driver.findElement(By.name("email")).sendKeys("alleyezonus@gmail.com");

        driver.findElement(By.linkText("Home")).click();

        System.out.println(driver.getCurrentUrl());


        BrowserUtils.wait(4);
        driver.close();
    }
}
