package tests.days.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Xpath {
    /*
            Xpath
                    1. absolute xpath
                        absolute XPath starts with the root of the HTML
                        to start a absolute xpath search place a front / continued with the root tagNames

                    2. relative xpath
                        Lets us start from anywhere in the document
                        starts with two front slashes //

                        //tagN ame[@attribute='value']

     */

    public static void main(String[] args) {
        // Absolute xpath
        WebDriver driver = BrowserFactory.getDriver("chrome");

//        // Vytrack login error message
//        driver.get("https://qa2.vytrack.com/user/login");
//        driver.findElement(By.id("_submit")).click();
//        WebElement warning = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/form/fieldset/div[1]/div"));
//        System.out.println(warning.getText());

            // bitrix login error message ABSOLUTE PATHWAY
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        System.out.println(warningMessage.getText());

        // bitrix login error message RELATIVE XPATH
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
        WebElement warningMessagetwo = driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println(warningMessagetwo.getText());

        driver.close();
    }
}
