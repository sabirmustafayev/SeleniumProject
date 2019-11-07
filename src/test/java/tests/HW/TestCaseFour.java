package tests.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCaseFour {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("123");
        String result = driver.findElement(By.xpath("//*[@id=\'registrationForm\']/div[1]/div/small[3]")).getText();
        System.out.println(result);

        driver.close();
    }
}
