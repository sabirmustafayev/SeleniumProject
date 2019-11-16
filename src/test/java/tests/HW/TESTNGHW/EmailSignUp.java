package tests.HW.TESTNGHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EmailSignUp {
    private WebDriver driver;

    @Test(description = "Verify that email sign up message is displayed and a verification email received")
    public void testCase6() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        String TempEmail = driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Nathan Buttons");
        driver.findElement(By.name("email")).sendKeys(TempEmail);
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement SignUpText = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(SignUpText.isDisplayed(), "Sign Up Message is not displayed");
        BrowserUtils.wait(10);
        driver.get("https://www.tempmailaddress.com/");

        WebElement ReceivedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        String ActualEmail = ReceivedEmail.getText();
        ActualEmail = ActualEmail.trim();
        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(ActualEmail, ExpectedEmail, "Email is not received");
        ReceivedEmail.click();

        String fromEmail = driver.findElement(By.id("odesilatel")).getText();
        String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromEmail, expectedFromEmail, "Wrong Sender");
        String ActualSubject = driver.findElement(By.id("predmet")).getText();
        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject line is wrong");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
