package tests.Vytrack;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;
import utils.BrowserUtils;


public class CreateCarTests extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.Login("storemanager85","UserUser123");
        loginPage.navigateTo("Fleet", "Vehicles");
        loginPage.waitUntilLoaderMaskDisappear();
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.clickToCreateACar();
        loginPage.waitUntilLoaderMaskDisappear();
        CreateCarPage createCarPage = new CreateCarPage();
        createCarPage.selectTags("Convertible");
        WebElement selection =createCarPage.selectTags("Convertible");
        Assert.assertTrue(selection.isSelected());
        createCarPage.selectFuelType("Gasoline");
        createCarPage.uploadLogo("/Users/Emrullah/Desktop/testFile.txt");
        BrowserUtils.wait(4);


    }
}
