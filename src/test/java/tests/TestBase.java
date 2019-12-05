package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//this class will be a test foundation for all test classes
//We will put here only before and after methods
public abstract class TestBase {

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    @BeforeTest()
    public void beforeTest(){
        String filePath = System.getProperty("user.dir")+"/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter =new ExtentHtmlReporter(filePath);
       extentReports.attachReporter(extentHtmlReporter);
       extentHtmlReporter.config().setReportName("Vytract Test Results");
       extentReports.setSystemInfo("Environment", "QA1");
       extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
       extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }

    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
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
        Driver.close();
    }
}
