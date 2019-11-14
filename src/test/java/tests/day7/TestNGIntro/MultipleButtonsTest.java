package tests.day7.TestNGIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultipleButtonsTest {
private WebDriver driver;
    @BeforeMethod
    public void setUp (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton1(){
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        String expectedResult ="Clicked on button one!";
        Assert.assertEquals(actualResult,expectedResult,"Result is wrong");
    }
    @Test
    public void verifyButton2(){
        driver.findElement(By.xpath("//*[text()='Button 2']")).click();
        String actualResult = driver.findElement(By.name("button2")).getText();
        String expectedResult ="Clicked on button two!";
        Assert.assertEquals(actualResult,expectedResult,"Result is wrong");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
