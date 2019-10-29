package tests.day3;


import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class DifferenceBetweenQuitAndClose {
    public static void main(String[] args) throws InterruptedException {
//       WebDriver driver = BrowserFactory.getDriver("chrome");
//      driver.get("http://practice.cybertekschool.com/open_new_tab");
//        Thread.sleep(5000);
//        driver.quit();
//
//        WebDriver driver2 = BrowserFactory.getDriver("FIREFOX");
//        driver2.get("http://google.com");

        WebDriver driver3 = BrowserFactory.getDriver("safari");
        driver3.get("http://practice.cybertekschool.com/open_new_tab");
        System.out.println(driver3.getPageSource());
        driver3.quit();





    }
}
