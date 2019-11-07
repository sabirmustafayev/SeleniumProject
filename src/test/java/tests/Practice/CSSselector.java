package tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserFactory;

public class CSSselector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/registration_form");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("James");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Bond");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("testcase@maildrop.cc");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("tqsdasadas");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("555-555-5555");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("bondJames");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");


        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");

        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        driver.quit();


    }
}
