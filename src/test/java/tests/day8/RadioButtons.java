package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test
    public void test1() {
        //The following element is a radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        Assert.assertTrue(blueButton.isSelected(), "Button is not selected");
    }

    @Test(description = "Verify that red button is not selected")
    public void test2() {
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected(), "Button is selected");
    }

    @Test(description = "Verify that green button is not clickable")
    public void test3() {
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled(), "Green Button is enabled");
    }

    @Test(description = "Click on every radio button one by one")
    public void test4() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type ='radio']"));
        for (WebElement button : radioButtons) {
            if (!button.isSelected() && button.isEnabled()) {
                button.click();
                System.out.println(button.getAttribute("id") + " is selected");
            } else {
                System.out.println("Button was not clicked " + button.getAttribute("id"));
            }
        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

