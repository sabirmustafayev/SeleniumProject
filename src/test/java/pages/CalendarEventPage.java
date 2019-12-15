package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CalendarEventPage extends BasePage{
    private GridOptions gridOptions = new GridOptions();

    @FindBy(css="[title='Create Calendar event']")
    public WebElement createCalendarEvents;

    @FindBy(css = "[class='fa-cog hide-text']")
    public WebElement gridOptionsElement;

    public void clickToCreateCalendarEvents(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(createCalendarEvents,5);
        BrowserUtils.waitForClickablility(createCalendarEvents,5);
       createCalendarEvents.click();

    }

    public WebElement tableElements(int row, int column){
        WebElement tableData = Driver.get().findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        return tableData;
    }

    public boolean gridOptionCheckbox(String name){
        return gridOptions.checkBox(name);
    }
    public boolean gridOptionsUnCheckBox(String name){
        return gridOptions.unCheckBox(name);
    }

    public void gridOptionsSelectAll(){
        gridOptions.SelectAll();
    }
    public void gridOptionsDeSelectAllExcept(String name){
        gridOptions.deSelectAll(name);
    }

}

class GridOptions{



    private String idFinder(String name){
        WebElement  x=  Driver.get().findElement(By.xpath("//label[contains(text(),'"+name+"')]"));
        String number = x.getAttribute("for").replace("column-c","");
       return number;
    }

    boolean checkBox(String name){
       String id = idFinder(name);
        WebElement option = Driver.get().findElement(By.cssSelector("#column-c"+id+"[type='checkbox']"));
        if(option.isSelected()){
            return true;
        }else if(!option.isSelected()){
            option.click();
            return true;
        }
        return false;
    }
    boolean unCheckBox(String name){
        String id = idFinder(name);
        WebElement option = Driver.get().findElement(By.cssSelector("#column-c"+id+"[type='checkbox']"));
        if(option.isSelected()){
            option.click();
            return true;
        }else if(!option.isSelected()){
            return true;
        }
        return false;
    }

    void SelectAll(){
        String [] names ={"Title","Calendar","Start","End","Recurrent","Recurrence","Invitation status"};
        for(String each: names){
            String id = idFinder(each);
                WebElement option = Driver.get().findElement(By.cssSelector("#column-c"+id+"[type='checkbox']"));
                if(option.isSelected()){
                    continue;
            }else if(!option.isSelected()){
                    option.click();
                }
        }
    }
    void deSelectAll(String name){
        String [] names ={"Title","Calendar","Start","End","Recurrent","Recurrence","Invitation status"};
        for(String each: names){
            String id = idFinder(each);
            WebElement option = Driver.get().findElement(By.cssSelector("#column-c"+id+"[type='checkbox']"));
            if(each.equals(name)){
                if(option.isSelected()){
                    continue;
                }else{
                    option.click();
                }
            }else if(option.isSelected()){
                option.click();
            }else if (!option.isSelected()){
                continue;
            }
        }
    }


}
