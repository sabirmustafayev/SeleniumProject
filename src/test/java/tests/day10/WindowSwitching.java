package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("New tab")).click();
    }

    @Test
    public void test1(){
        BrowserUtils.wait(4);
        //after 3 seconds a new tab opens. Selenium does not switch to new tab automatically
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice", "Title is wrong");
    }

    @Test(description = "Verify that user successfully opened a new tab")
    public void test2(){
        BrowserUtils.wait(4);
        //record id of initial tab
        String oldWindow = driver.getWindowHandle();
        //We can access list of all tab id's
        Set<String>windowHandles = driver.getWindowHandles();
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(oldWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab", "Title is wrong");
        //Comeback to original page using title
        for(String windowHandle: windowHandles){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("Practice")){
                break;
            }
        }

        System.out.println(driver.getTitle());


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
