package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    @FindBy(id ="prependedInput")
    private WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement loginBtn;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    public void Login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 //       this.waitUntilLoaderMaskDisappear();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }
}
