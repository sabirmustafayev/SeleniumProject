package tests.days.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {

    @Test(description = "drag and drop")
    public void test2(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        WebElement blueBall = driver.findElement(By.id("draggable"));
        WebElement dropPoint = driver.findElement(By.id("droptarget"));
        driver.findElement(By.cssSelector("[title ='Accept Cookies']")).click();
        BrowserUtils.wait(3);
        action.dragAndDrop(blueBall,dropPoint).perform();
        BrowserUtils.wait(3);

        driver.quit();
    }
}
