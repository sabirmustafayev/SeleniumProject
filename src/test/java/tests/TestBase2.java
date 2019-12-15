package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;

import utils.Driver2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase2 {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest()
    @Parameters({"test","env_url"})
    public void beforeTest(@Optional String test, @Optional String env_url){
        String reportName="report";
        if(test != null){
            reportName = test;
        }
        SimpleDateFormat df = new SimpleDateFormat("-yyyy-MM-dd-HH-mm");
        String date = df.format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/report"+reportName+".html";
        extentReports = new ExtentReports();
        extentHtmlReporter =new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
        String env = ConfigurationReader.getProperty("url");
        if(env_url != null){
            env =env_url;
        }
        extentReports.setSystemInfo("Environment", env);
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }

    @BeforeMethod
    @Parameters("env_url")
    public void setUp(@Optional String env_url){
        Driver2.intiDriver();
        String url = ConfigurationReader.getProperty("url");
        if(env_url != null){
            url= env_url;
        }
        Driver2.getDriver2().get(url);
        //Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail((result.getName()));
            extentTest.fail(result.getThrowable());
            try {
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus()==ITestResult.SKIP){
            extentTest.skip("Test case was skipped: " + result.getName());
        }

        Driver2.closeDriver2();
    }

    @AfterSuite
    public void afterSuite(){
        Driver2.shutDownDrivers();
    }

}
