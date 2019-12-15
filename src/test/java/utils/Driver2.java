package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver2 {
    private  static RemoteWebDriver driver;
    private static ThreadLocal<WebDriver> driver2 = new ThreadLocal<>();
    private static String browser = ConfigurationReader.getProperty("browser");
    private static final Logger logger = LogManager.getLogger(Driver.class);

    private Driver2(){

    }
    public synchronized static RemoteWebDriver get(){
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chromeHeadless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefoxHeadless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "safari":
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                        throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                    }
                    driver = new SafariDriver();
                    break;
                case "ie":
                    if(System.getProperty("os.name").toLowerCase().contains("mac")){
                        throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    //If browser type is wrong, stop tests and throw exception
                    throw new RuntimeException("Illegal browser type");
            }

        }
        return driver;
    }
    public synchronized static void intiDriver(){

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver2.set(new ChromeDriver());
                break;
            case "chromeHeadless":
                WebDriverManager.chromedriver().setup();
                driver2.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver2.set(new FirefoxDriver());
                break;
            case "firefoxHeadless":
                WebDriverManager.firefoxdriver().setup();
                driver2.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                break;
            case "safari":
                if(System.getProperty("os.name").toLowerCase().contains("windows")){
                    throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                }
                driver2.set(new SafariDriver());
                break;
            case "ie":
                if(System.getProperty("os.name").toLowerCase().contains("mac")){
                    throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                }
                WebDriverManager.iedriver().setup();
                driver2.set(new InternetExplorerDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver2.set(new EdgeDriver());
            default:
                 logger.error("Illegal browser type :: "+ browser);
                //If browser type is wrong, stop tests and throw exception
                throw new RuntimeException("Illegal browser type");
        }

         logger.info("Thread id: "+ new Thread().getId());

    }

    public static void close(){
        if (driver != null) {
            //close all browsers
            driver.quit();
            //destroy driver object
            driver = null;
        }

    }

    public static void closeDriver2(){
        driver2.get().quit();
    }

    public static WebDriver getDriver2(){
        return driver2.get();
    }

    public static void shutDownDrivers(){
        driver2.remove();
    }

}
