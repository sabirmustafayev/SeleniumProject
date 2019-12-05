package tests.Vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;

public class CreateCalendarEventPageTests extends TestBase {

    @Test(description = "Verify owners name is equals Stephan Haley")
    public void test1(){
        LoginPage login = new LoginPage();
        login.Login("storemanager85","UserUser123");
        login.navigateTo("Activities","Calendar Events");
        CreateCalendarEventPage owner = new CreateCalendarEventPage();
       owner.clickToCreateCalendarEvents();
       String expectedOwner =" Stephan Haley";
       String actualOwner = owner.owner.getText();
        Assert.assertEquals(actualOwner,expectedOwner,"Owner name do not match");
    }
}
