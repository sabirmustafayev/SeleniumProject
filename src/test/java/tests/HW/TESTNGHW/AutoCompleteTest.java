package tests.HW.TESTNGHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class AutoCompleteTest {

    @Test
    public void AutoComplete(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();

        WebElement autoComplete = driver.findElement(By.id("myCountry"));
        autoComplete.sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();

        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult= "You selected: United States of America";
        Assert.assertEquals(actualResult,expectedResult,"Message is wrong");

        driver.quit();

    }
}
