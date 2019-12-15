package tests.days.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CSSSelector {
    public static void main(String[] args) {
        /*
                CssSelector : great performance minimal process:

                    TagName[attribute ='value']

                    ^ --> startsWith
                    * --> contains
                    $ --> endsWith

                    [id ^ = 'button_']  starts with button_
                    [id * = 'd' ]  contains d
                    [id $ ='set'] ends with set

               Moving from parent to child :

                    space or >

                    space in between means any child
                    > means next child in line

         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        System.out.println(buttons.size());
        for(WebElement each: buttons){
            each.click();
            System.out.println(driver.findElement(By.id("result")).getText());
            BrowserUtils.wait(1);
        }


        driver.close();
    }
}
