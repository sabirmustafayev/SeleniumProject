package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import utils.Driver2;

public class BasePage2 {

    @FindBy(css = "div[class='loader-mask shown']")
    private WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    private WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    private WebElement userName;

    @FindBy(linkText = "Logout")
    private WebElement logOutLink;

    @FindBy(linkText = "My User")
    private WebElement myUser;

    public BasePage2() {
        PageFactory.initElements(Driver2.getDriver2(),this);

    }
    public boolean waitUntilLoaderMaskDisappear(){
        WebDriverWait wait=wait= new WebDriverWait(Driver2.getDriver2(),3);
        //wait.until(ExpectedConditions.visibilityOf(loaderMask));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class ='loader-mask shown']")));
            return true;
        }catch(NoSuchElementException e) {
            System.out.println("Loader mask not found");
            System.out.println(e.getMessage());
            return true;
        }catch
        (WebDriverException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public void navigateTo(String moduleName, String subModuleName){
        WebDriverWait wait=wait= new WebDriverWait(Driver2.getDriver2(),10);
        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class='title title-level-1']";
        String subModuleLocator="//*[normalize-space()='"+subModuleName+"' and @class='title title-level-2']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

        WebElement module = Driver2.getDriver2().findElement(By.xpath(moduleLocator));
        WebElement subModule = Driver2.getDriver2().findElement(By.xpath(subModuleLocator));

        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));
        module.click();

        wait.until(ExpectedConditions.visibilityOf(subModule));
        wait.until(ExpectedConditions.elementToBeClickable(subModule));
        subModule.click();
        BrowserUtils.waitForPageToLoad(15);
    }

    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }
    public String getUserName(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }
    public void logOut(){
        BrowserUtils.wait(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();
    }
}
