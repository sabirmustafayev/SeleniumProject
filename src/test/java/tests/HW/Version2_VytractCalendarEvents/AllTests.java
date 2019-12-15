package tests.HW.Version2_VytractCalendarEvents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

import utils.Driver;
import utils.Pages;

public class AllTests extends TestBase {
        private  Pages pages = new Pages();

    @Test(description = "Verify that 'view', 'edit' and 'delete' options are available for each calendar event")
    public void test1(){
        pages.loginPage().Login("storemanager85","UserUser123");
        pages.loginPage().navigateTo("Activities","Calendar Events");
        pages.loginPage().waitUntilLoaderMaskDisappear();

        WebElement hoverPoint = pages.calendarEventPage().tableElements(1,9);
        Actions action = new Actions(Driver.get());
        action.moveToElement(hoverPoint).build().perform();
        String[] testData ={"a[href='#']", "a[href='/calendar/event/update/174']","a[href='/calendar/event/view/174']"};
        WebElement option;
        for (String each : testData) {
            option = Driver.get().findElement(By.cssSelector(each));
            Assert.assertTrue(option.isDisplayed());
        }
    }

    @Test(description = "Verify that title column is displayed")
    public void testCase2() {
        pages.loginPage().Login("storemanager85","UserUser123");
        pages.loginPage().navigateTo("Activities","Calendar Events");
        pages.loginPage().waitUntilLoaderMaskDisappear();

        pages.calendarEventPage().gridOptionsElement.click();
        pages.calendarEventPage().gridOptionsDeSelectAllExcept("Title");





    }

}
