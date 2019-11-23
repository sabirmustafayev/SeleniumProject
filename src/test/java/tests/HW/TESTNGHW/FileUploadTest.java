package tests.HW.TESTNGHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class FileUploadTest {

    @Test
    public void FileUploadTest() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        // Select and Upload File
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // chooseFile.click(); NOT NEEDED MESSES UP CODE
        chooseFile.sendKeys("/Users/Emrullah/Desktop/testFile.txt");
        driver.findElement(By.id("file-submit")).click();
        //Verify that upload verification message displayed
        WebElement SuccessMessage = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded')]"));
        String actualSuccessMessage = SuccessMessage.getText();
        String expectedSuccessMessage = "File Uploaded!";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success Message is not correct");
        WebElement FileName = driver.findElement(By.id("uploaded-files"));
        //Verify that uploaded file name is displayed
        String actualFileName = FileName.getText();
        String expectedFileName = "testFile.txt";
        Assert.assertEquals(actualFileName, expectedFileName, "File name do not match");
        Assert.assertTrue(FileName.isDisplayed(), "File Name is not displayed");

        driver.quit();
    }
}
