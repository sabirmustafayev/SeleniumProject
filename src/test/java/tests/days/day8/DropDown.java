package tests.days.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDown {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test(description = "")
    public void test1(){
        WebElement dropdown =driver.findElement(By.cssSelector("[id='dropdown']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "Print all states and select one")
    public void test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select((state));
        List<WebElement> states = select.getOptions();
        for(WebElement option: states){
            System.out.println(option.getText());
        }
    }

    @Test(description = "Select State and verify that state is selected")
    public void test3(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("NJ");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"New Jersey");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
