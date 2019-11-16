package tests.day9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.Arrays;

public class TestNGReview {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        System.out.println("Before Method!");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("After method!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @DataProvider(name = "testData")
    public static Object [][] testData(){
        return new Object [][] {{"https://www.apple.com", "Apple"},{"https://google.com", "Google"}};
    }

    @Test(dataProvider = "testData")
    public void testDataWithProvider (String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }
}
