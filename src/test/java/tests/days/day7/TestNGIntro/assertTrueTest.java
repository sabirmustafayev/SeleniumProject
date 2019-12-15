package tests.days.day7.TestNGIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class assertTrueTest {


    @Test
    public void test(){
        Assert.assertEquals("appl", "apple", "Word is not correct! should be apple!");

    }

    @Test
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Practice", "Title should be Practice");
        driver.close();
    }

    @Test(description = "Verify that heading displayed and is correct")
    public void verifyHeading(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        String expected = "Test Automation Practice";
        WebElement heading = driver.findElement(By.cssSelector("[class= 'h1y']"));

        Assert.assertTrue(heading.isDisplayed(), "Element is not visible");
        String actual = heading.getText();

        Assert.assertEquals(actual,expected,"Heading is wrong");

        driver.close();
    }

}
