package tests.days.day7.TestNGIntro;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class AnnotationsTest {
    @BeforeMethod
            public WebDriver setUp() {
        System.out.println("Before Test");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        return driver;

    }

    @Test
    public void test1(){
        WebDriver driver = setUp();
        System.out.println(driver.getTitle());
       System.out.println("Test 1");
       driver.close();
    }
    @Test
    public void test2(){
        WebDriver driver = setUp();
        driver.navigate().to("http://amazon.com");
        System.out.println(driver.getTitle());
        System.out.println("Test 2");
        driver.close();
    }
    @Test
    public void test3(){
        WebDriver driver = setUp();
        driver.navigate().to("http://facebook.com");
        System.out.println(driver.getTitle());
        System.out.println("Test 3");
        driver.close();
    }

    @AfterMethod
    public void closeDriver(){
        System.out.println("Test complete");
    }
}
