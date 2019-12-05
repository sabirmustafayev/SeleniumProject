package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CalendarEventPage extends BasePage{

    @FindBy(css="[title='Create Calendar event']")
    public WebElement createCalendarEvents;

    public void clickToCreateCalendarEvents(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(createCalendarEvents,5);
        BrowserUtils.waitForClickablility(createCalendarEvents,5);
       createCalendarEvents.click();

    }
}
