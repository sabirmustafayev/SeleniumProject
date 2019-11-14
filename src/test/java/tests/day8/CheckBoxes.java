package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test(description = "Verify that checkboxes are clickable")
    public void test1() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(WebElement checkbox: checkboxes){
            if(!checkbox.isSelected() && checkbox.isEnabled()){
                checkbox.click();
                System.out.println("Selected " + checkbox.getText());
            }else {
                System.out.println("Not selected " + checkbox.getText());
            }
        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
