package tests.Vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class NEWCalendarEventTests extends TestBase {

    @Test(description = "Verify that page subtitle is euqals to 'All Calendar events' ")
    public void test1(){
        extentTest=extentReports.createTest("Verify that page subtitle is euqals to 'All Calendar events'");
        LoginPage loginPage= new LoginPage();
        loginPage.Login("storemanager85","UserUser123");
        loginPage.navigateTo("Activities","Calendar Events");
        String expectedSubtitle ="All Calendar Events";
        String actualSubtitle =loginPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Wrong Subtitle");

        extentTest.pass("Verify that sub title of calendar events is displayed");
    }

}
