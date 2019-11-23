package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class FramesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Frames")).click();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test (description = "Switching between frames, iFrame")
    public void test() {
        driver.findElement(By.linkText("iFrame")).click();
        //switch to frame within the website using id of the frame
        driver.switchTo().frame("mce_0_ifr");
        WebElement inputArea = driver.findElement(By.id("tinymce"));
        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText,expectedText,"Input text is wrong");
        // exit from frame
        driver.switchTo().defaultContent();
    }


    //in case of nested frames we must switch to first frame --> then again to another frame
    // html
    // frame #1
    // ----- frame #2
    @Test(description = "Nested Frames")
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));

        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftContent = driver.findElement(By.tagName("body"));
        System.out.println(leftContent.getText());
    }
}
