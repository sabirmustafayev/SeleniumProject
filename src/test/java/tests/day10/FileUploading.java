package tests.day10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setUp (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("File Upload")).click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.id("file-upload")).sendKeys("/Users/Emrullah/Desktop/testFile.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);

    }
}
