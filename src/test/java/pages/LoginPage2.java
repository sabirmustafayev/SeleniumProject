package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver2;

import java.util.concurrent.TimeUnit;

public class LoginPage2 extends BasePage2 {


        @FindBy(id = "prependedInput")
        private WebElement userNameInput;

        @FindBy(id = "prependedInput2")
        private WebElement passwordInput;

        @FindBy(id = "_submit")
        private WebElement loginBtn;

        @FindBy(css = "[class='alert alert-error']")
        private WebElement warningMessage;


        public LoginPage2() {
            PageFactory.initElements(Driver2.getDriver2(), this);
        }

        public void Login(String username, String password) {
            userNameInput.sendKeys(username);
            passwordInput.sendKeys(password, Keys.ENTER);
            Driver2.getDriver2().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //       this.waitUntilLoaderMaskDisappear();
            try {
                WebDriverWait wait = new WebDriverWait(Driver2.get(), 10);
                WebElement loaderMask = Driver2.getDriver2().findElement(By.cssSelector("div[class='loader-mask shown']"));
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            } catch (Exception e) {

            }

        }
    }

