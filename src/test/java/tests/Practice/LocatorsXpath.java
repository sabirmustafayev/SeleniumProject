package tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class LocatorsXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
         driver.get("https:practice.cybertekschool.com");

         //absolute xpath
        WebElement dropDownLink =driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[11]/a"));
        System.out.println(dropDownLink.getText());
        dropDownLink.click();
        Thread.sleep(3000);

        //relative xpath
        /*
                Xpath example = //tagName[@attribute = 'value']
                // beginning of element
                tagName= tag name of element
                @ select attribute
                attribute atribute of the element

         */
        driver.get("https:practice.cybertekschool.com");
        WebElement title = driver.findElement(By.xpath("//span[@class='h1y']"));
        System.out.println(title.getText());
        WebElement contextMenu= driver.findElement(By.xpath("//a[.='Context Menu']"));
        contextMenu.click();
        Thread.sleep(3000 );

        driver.close();
    }
}
