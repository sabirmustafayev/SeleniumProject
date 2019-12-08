package tests.Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DateSelection {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void test1() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.trivago.com/");

        driver.findElement(By.id("querytext")).sendKeys("Florida");
        driver.findElement(By.xpath("//span[@class='flex']")).click();
        BrowserUtils.wait(3); // Wait for pop up selection window
        driver.findElement(By.cssSelector("[datetime='2019-12-09']")).click();
        BrowserUtils.wait(3);// Wait for pop up selection window
        driver.findElement(By.cssSelector("[datetime='2019-12-14']")).click();

    }

    @Test
    public void test() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 15);
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activities = driver.findElement(By.xpath("//span[contains(text(),'Activities')][1]"));
        wait.until(ExpectedConditions.visibilityOf(activities));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(activities);
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        activities.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement options = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(options));
        Assert.assertTrue(options.isDisplayed());
    }

}
