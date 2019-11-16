package tests.HW.TESTNGHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class StatusCodes {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @DataProvider(name = "testData")
    public static Object[] testData() {
        return new Object[]{"200", "301", "404", "500"};
    }

    @Test(dataProvider = "testData")
    public void StatusCodes(String errorCode) {
        WebElement codeNumber = driver.findElement(By.linkText(errorCode));
        codeNumber.click();
        WebElement result = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(result.getText().contains(errorCode), "Wrong Error code");
        driver.findElement(By.linkText("here")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
