package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com");
       List<WebElement> aTag = driver.findElements(By.tagName("a"));
        System.out.println(aTag.size());

        for(WebElement each: aTag){
            if(each.getText().isEmpty()){
                continue;
            }
            System.out.println(each.getText());
        }

        driver.close();
    }
}
