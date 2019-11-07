package tests.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCaseThree {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult ="Clicked on button one!";

        System.out.println("Expected Result : " + expectedResult);
        System.out.println("Actual Result : " + actualResult);
        if(actualResult.equals(expectedResult)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();


    }
}
