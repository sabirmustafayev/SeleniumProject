package tests.HW.BasicNavigationHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCaseOne {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Cagri Durmaz");
        driver.findElement(By.name("email")).sendKeys("testcase@maildrop.cc");
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualResult = driver.findElement(By.name("signup_message")).getText();
        String expectedResultTwo = "Home";
        String actualResultTwo = driver.findElement(By.id("wooden_spoon")).getText();
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual: " + actualResult);
        if(expectedResult.equals(actualResult)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        System.out.println("Expected: " + expectedResultTwo);
        System.out.println("Actual: " + actualResultTwo);
        if(expectedResultTwo.equals(actualResultTwo)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();

    }
}
