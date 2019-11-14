package tests.HW.TESTNGHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class RegistrationForm {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "Verify that DOB error message is displayed")
    public void testCase1() {
        String expectedResult = "The date of birth is not valid";
        driver.findElement(By.name("birthday")).sendKeys("wrong_dub");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");
    }

    @Test(description = "Verify that c++. java and Javascript is displayed")
    public void testCase2() {
        WebElement cPlusPlus = driver.findElement(By.cssSelector("label[for='inlineCheckbox1']"));
        WebElement java = driver.findElement(By.cssSelector("label[for='inlineCheckbox2']"));
        WebElement javaScript = driver.findElement(By.cssSelector("label[for='inlineCheckbox3']"));
        Assert.assertTrue(cPlusPlus.isDisplayed(), "C++ is not displayed");
        Assert.assertTrue(java.isDisplayed(), "Java is not displayed");
        Assert.assertTrue(javaScript.isDisplayed(), "JavaScript is not displayed");

    }

    @Test(description = "Verify that invalid input to first name box gives error message")
    public void testCase3() {
        String expectedResult = "first name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("firstname")).sendKeys("A");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[text( )='first name must be more than 2 and less than 64 characters long']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[text( )='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");

    }

    @Test(description = "Verify that invalid input to last name box gives error message")
    public void testCase4() {
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("lastname")).sendKeys("A");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");

    }

    @Test(description = "Verify that after successful sign up verification message is displayed")
    public void testCase5() {
        String expectedResult = "You've successfully completed registration!";
        driver.findElement(By.name("firstname")).sendKeys("Nathan");
        driver.findElement(By.name("lastname")).sendKeys("Benedict");
        driver.findElement(By.name("username")).sendKeys("NatBen");
        driver.findElement(By.name("email")).sendKeys("nathan@email.com");
        driver.findElement(By.name("password")).sendKeys("dangerZone");
        driver.findElement(By.name("phone")).sendKeys("201-654-8871");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        Select jobTitle = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        Select department = new Select(driver.findElement(By.cssSelector("[name='department']")));
        department.selectByVisibleText("MCR");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        WebElement verificationMessage = driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue(verificationMessage.isDisplayed(), "Message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Verification message is not displayed properly");


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
