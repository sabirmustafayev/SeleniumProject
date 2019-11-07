package tests.Vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class VerifyLogin {
    public static void main(String[] args) {
        //chromeTest();
        //firefoxTest();
        safariTest();

    }

    public static void chromeTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://qa2.vytrack.com/user/login");
        String initialUrl = driver.getCurrentUrl();

        driver.findElement(By.id("prependedInput")).sendKeys("user48");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        String finalUrl = driver.getCurrentUrl();
        String expected = "https://qa2.vytrack.com/";

        System.out.println("Initial URl: " + initialUrl);
        System.out.println("final URl: " + finalUrl);
        System.out.println("Expected URL: " + expected);
        String result = (finalUrl.equalsIgnoreCase(expected))?"PASSED": "FAILED";
        BrowserUtils.wait(2);
        System.out.println(result);

        driver.quit();
    }

    public static void firefoxTest(){
        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("http://qa2.vytrack.com/user/login");
        String initialUrl = driver.getCurrentUrl();

        driver.findElement(By.id("prependedInput")).sendKeys("user48");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        String finalUrl = driver.getCurrentUrl();
        String expected = "https://qa2.vytrack.com/";

        System.out.println("Initial URl: " + initialUrl);
        System.out.println("final URl: " + finalUrl);
        System.out.println("Expected URL: " + expected);
        String result = (finalUrl.equalsIgnoreCase(expected))?"PASSED": "FAILED";
        BrowserUtils.wait(2);
        System.out.println(result);

        driver.quit();
    }

    public static void safariTest(){
        WebDriver driver = BrowserFactory.getDriver("safari");

        driver.get("http://qa2.vytrack.com/user/login");
        String initialUrl = driver.getCurrentUrl();

        driver.findElement(By.id("prependedInput")).sendKeys("user48");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        WebElement click = driver.findElement(By.name("_submit"));
        click.submit();
        BrowserUtils.wait(2);

        String finalUrl = driver.getCurrentUrl();
        String expected = "https://qa2.vytrack.com/";

        System.out.println("Initial URl: " + initialUrl);
        System.out.println("final URl: " + finalUrl);
        System.out.println("Expected URL: " + expected);
        String result = (finalUrl.equalsIgnoreCase(expected))?"PASSED": "FAILED";
        BrowserUtils.wait(2);
        System.out.println(result);

        driver.quit();
    }
}
