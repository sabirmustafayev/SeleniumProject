package tests.days.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;




import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test(description = "Implicit Wait example")
    public void test1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();


        WebElement result = driver.findElement(By.id("finish"));
        System.out.println(result.getText());

    }

    @Test(description = "Explicit wait example")
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //apply condition
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
       driver.findElement(By.cssSelector("[type='submit']")).click();
       WebElement message = driver.findElement(By.tagName("h4"));
       wait.until(ExpectedConditions.visibilityOf(message));
       String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String  actualMessage = message.getText();
        System.out.println(actualMessage);
    }

    @Test
    public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
