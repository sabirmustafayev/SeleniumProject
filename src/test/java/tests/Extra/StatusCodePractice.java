package tests.Extra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.HW.TESTNGHW.StatusCodes;
import utils.BrowserFactory;

public class StatusCodePractice {
  private WebDriver driver; //Shared upon all methods

    @BeforeMethod
    public void setUp()  throws InterruptedException{
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver1 = new ChromeDriver();
        driver = BrowserFactory.getDriver("chrome");
        Thread.sleep(500);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        /*
                id
                linkText --> Full Text
                partialLinkText --> Part of Text
                className
                tagName -->(Worst way to go)
                cssSelector

                xpath -->Guaranteed Way. There is always an xpath.

                Which one to choose:
                    1. Id
                    2. cssSelector
                    3. relative xpath


         */
        driver.findElement(By.linkText("Status Codes")).click();

    }

    @DataProvider(name="testData")
            public static Object [] testData(){
                Object [] data = new Object [] {"200","301","404","500"};
                return data;
            }

    @Test (dataProvider = "testData") // (description = "Verify that following message is displayed: “This page returned a 200 status code")
    public void test1(String StatusCodes){
        WebElement codeNumber = driver.findElement(By.linkText(StatusCodes));
        codeNumber.click();
//        String expected = "This page returned a " +StatusCodes+" status code.";
        WebElement result = driver.findElement(By.xpath("//p"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains(StatusCodes),"Wrong Error Code");
    }
//    @Test (description = "Verify that following message is displayed: “This page returned a 301 status code")
//    public void test2(){
//        WebElement codeNumber = driver.findElement(By.linkText("301"));
//        codeNumber.click();
//        String expected = "This page returned a 301 status code.";
//        WebElement result = driver.findElement(By.xpath("//p"));
//        System.out.println(result.getText());
//        Assert.assertTrue(result.getText().contains(expected),"Wrong Error Code");
//    }

    @AfterMethod // close the browser
    public void teardown(){
        driver.quit();
    }





}
