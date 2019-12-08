package tests.Vytrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class SmokeTest extends TestBase {


    @Test(dataProvider = "navigationInfo")
    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle){
        extentTest=extentReports.createTest("Verify that page subtitle is equals to '"+ pageSubTitle+"'.");
        LoginPage loginPage= new LoginPage();
        loginPage.Login("storemanager85","UserUser123");
        loginPage.navigateTo(moduleName,subModuleName);
        loginPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(loginPage.getPageSubTitle(),pageSubTitle,"Title do not match");
        extentTest.pass("Verify that sub title of "+ subModuleName +" is displayed");
    }


    @DataProvider(name = "navigationInfo")
    public Object [][] navigationInfo(){

        return new Object[][]{
                {"Dashboards","Dashboard","Dashboard"},
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards"},
                {"Fleet","Vehicles","All Cars"},
                {"Customers","Accounts","All Accounts"},
                {"Activities","Calendar Events","All Calendar Events"},
                {"Sales","Opportunities","Open Opportunities"}

        };

    }
}
