package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class PopUp_Alert {
    private WebDriver driver;
    @BeforeMethod
    public void setUp (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = "Verfiy that alert box is confirmed")
    public void test1(){
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test(description ="Verify that alert box is cancelled")
    public void test2(){
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
        String expected ="You clicked: Cancel";
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),expected,"Wrong result");
    }

    @Test(description = "Verify that you can send messages to alert box")
    public void test3(){
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
    }
}
