package tests.days.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class ActionsPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Hovers")).click();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Hovers example: verify first image")
    public void test1(){

        Actions action = new Actions(driver);
        WebElement image1= driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        action.moveToElement(image1).perform();
        String expectedText ="name: user1";
        String actualText =driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5")).getText();
        Assert.assertEquals(actualText,expectedText,"text do not match");
    }


}
