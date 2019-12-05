package tests.Vytrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;

public class LoginTests extends TestBase {

    @Test
    public void test1(){
        LoginPage login = new LoginPage();
        login.Login("storemanager85","UserUser123");
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.get().getTitle(),"Dashboard","Login Failed");

       login.navigateTo("Fleet","Vehicles");
      BrowserUtils.wait(3);

    }
}
