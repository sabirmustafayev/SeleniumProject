package tests.days.day20_DDT;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestWithExcel extends TestBase {
    /*
            DDT--> Data Driven testing is a sogtware testing methodology. The idea is to test data without creating
            variables for it coming from an outer source.
     */
    @DataProvider(name = "credentials")
    public static Object [][]credentials(){
        ExcelUtil qa2= new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
        return qa2.getDataArray();
    }

    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result) {
        //is must because we will ge null pointer exception
        extentTest = extentReports.createTest("Login as "+username);
        if(username.equals("username")){
            //will make test skipped
            //it will not fail
            //because first row is dedicated to column names
            throw new SkipException("Test was skipped because it's first row!");
        }else{
            LoginPage loginPage = new LoginPage();
            loginPage.Login(username, password);
            //put here wait for title to be "Dashboard"
            BrowserUtils.waitForPageTitle("Dashboard");
            Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
            extentTest.pass("Login test passed for user "+username);
        }
    }

    public static void main(String[] args) {
        ExcelUtil qa2= new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
        System.out.println("Row count: " + qa2.rowCount());
       for(Map<String, String> map: qa2.getDataList()){
           System.out.println(map);
       }
    }
}
