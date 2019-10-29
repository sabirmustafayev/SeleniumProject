package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Asi Cocuk");
        driver.findElement(By.name("email")).sendKeys("alleyezonus@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();

        System.out.println(driver.getCurrentUrl());


        BrowserUtils.wait(4);

       WebElement sub_header = driver.findElement(By.tagName("h3"));
        System.out.println(sub_header.getText());



        driver.quit();
    }
}
