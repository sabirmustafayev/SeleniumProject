package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("opear")){
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }else if(browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internet explorer")){
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }else if (browser.equalsIgnoreCase("safari")){
            return new SafariDriver();
        }
        return null;


    }


}
