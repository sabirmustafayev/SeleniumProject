package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;

    @FindBy(name="custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name="custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css ="div[id*='FuelType']")
    public WebElement fuelTypeElement;

    //if this locator doesn't work, use
     //@FindBy(css="[id^='uniform-custom_entity_type_Logo_file'] > span[class='action']")
    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;


    //This method is to select tags
    //Provide tag name to select
    //If tag is already selected then it will not do anything
    public WebElement selectTags(String tagName){
        String locator ="//label[text()='"+tagName+"']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkBox,15);
        BrowserUtils.waitForClickablility(checkBox,15);
        if(!checkBox.isSelected()){
            checkBox.click();
        }

        return checkBox;
    }

    public void selectFuelType(String fuelType){
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();
    }

    public void uploadLogo(String pathToTheFile){
        BrowserUtils.waitForVisibility(logoElement,15);
        logoElement.sendKeys(pathToTheFile);
    }



}
