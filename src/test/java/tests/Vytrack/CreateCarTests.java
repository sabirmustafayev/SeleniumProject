package tests.Vytrack;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;
import tests.days.day15.ConfigReaderTest;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;
import utils.ExcelUtil;

import java.util.List;
import java.util.Map;


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
    }

    @Test
    public void createCarTest(){
        extentTest = extentReports.createTest("Create a new car");
        Driver.get().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        String username= ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");

        loginPage.Login(username,password);
        loginPage.navigateTo("Fleet", "Vehicles");
        loginPage.waitUntilLoaderMaskDisappear();

        vehiclesPage.clickToCreateACar();
        loginPage.waitUntilLoaderMaskDisappear();

        ExcelUtil cars = new ExcelUtil("/Users/Emrullah/Downloads/CreateCarData.xlsx","Sheet1" );

        List<Map< String, String>> testData = cars.getDataList();

//        createCarPage.licensePlateElement.sendKeys(testData.get(0).get("License Plate"));
//        createCarPage.driverElement.sendKeys(testData.get(0).get("Driver"));
//        createCarPage.modelElement.sendKeys(testData.get(0).get("Model Year"));
//        createCarPage.colorElement.sendKeys(testData.get(0).get("Color"));
        for(Map<String, String> each: testData){
            createCarPage.licensePlateElement.sendKeys(each.get("License Plate"));
            createCarPage.driverElement.sendKeys(each.get("Driver"));
            createCarPage.modelElement.sendKeys(each.get("Model Year"));
            createCarPage.colorElement.sendKeys(each.get("Color"));
        }

        BrowserUtils.wait(5);
        extentTest.pass("New car was created");

        for(Map<String, String> each: testData){
            createCarPage.licensePlateElement.sendKeys(each.get("License Plate"));
            createCarPage.driverElement.sendKeys(each.get("Driver"));
            createCarPage.modelElement.sendKeys(each.get("Model Year"));
            createCarPage.colorElement.sendKeys(each.get("Color"));
        }


    }
}
