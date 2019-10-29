package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    /*

     */


    public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com"); // open URL
        Thread.sleep(3000);
        driver.navigate().to("http://amazon.com"); // load a new webpage in open browser
        Thread.sleep(3000);
        driver.navigate().back(); // move to previous browser in history
        Thread.sleep(3000);
        driver.navigate().forward(); // move forward in browser history unless its the latest page.
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.close(); // will close web browsers
    }
}
