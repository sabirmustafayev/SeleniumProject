package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WebTable {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }

    @Test
    public void test1(){

        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
    }

    @Test (description = "Verify that number of columns in the first table is equal to 6")
    public void test2(){
        int actualColumnNumber =driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber =6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber,"The column number is wrong");
    }

    @Test(description = "Verify that number of rows is equals to 5")
    public void test4(){
        int actualRownNumber =driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        int expectedRowNumber =5;
        Assert.assertEquals(actualRownNumber,expectedRowNumber, "The row number is wrong");
    }

    @Test(description = "Print all the values from 2nd row (excluding table header")
    public void test5(){
        String rowTwo = driver.findElement(By.xpath("//table[@id='table1']//tr[2]")).getText();
                                                    //table[id=‘table1’] tbody tr:nth-of-type(2) td (CSS SELECTOR)
        System.out.println(rowTwo);
        List<WebElement> rowTwoData = driver.findElements(By.xpath("//table[@id='table1']//tr[2]//td")); //
        for(WebElement each:rowTwoData){
            System.out.println(each.getText());
        }
    }

    @Test(description = " Verify that the email in row 3 column 3 is equal to jdoe@hotmail.com")
    public void test6(){
        int row =3;
        int column = 3;
        WebElement emailData = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
       String actualEmail = emailData.getText();
       String expectedEmail ="jdoe@hotmail.com";
       Assert.assertEquals(actualEmail,expectedEmail, " Emails do not match");
    }

    @Test
    public void test7(){
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        for(WebElement each : emails){
            Assert.assertTrue(each.getText().contains("@"));
        }
    }

    @Test(description = "Verify that once the last name header is clicked the list is sorted in ascending order")
    public void test8(){
        driver.findElement(By.xpath("//span[contains(text(),'Last Name')]")).click();
        List <WebElement> lastNameOrder = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        for(int i =0; i<=lastNameOrder.size()-2;i++){
            Assert.assertTrue(lastNameOrder.get(i).getText().compareTo(lastNameOrder.get(i+1).getText())<=0);
        }
        /*
                compareTo
                        if result is <0, sequence of words i correct
                        if 0 then equal
                        if result >0 the sequence of words is wrong
         */

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
