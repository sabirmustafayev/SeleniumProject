package tests.Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import java.util.List;
public class RF {
    @Test(description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void test2(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.partialLinkText("Registration")).click();
        List<WebElement>langs=driver.findElements(By.cssSelector("[class='form-check-label']"));

        for(WebElement each: langs){
            Assert.assertTrue(each.isDisplayed(), " Checkbox is not dosplayed");
            System.out.println("Language " + each.getText());
        }


    }
}