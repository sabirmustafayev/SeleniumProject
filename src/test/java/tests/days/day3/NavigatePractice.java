package tests.days.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigatePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        BrowserUtils.wait(2);
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("http://amazon.com");
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.wait(2);
        driver.navigate().back();
        BrowserUtils.wait(2);
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.wait(2);
        driver.quit();

    }
}
