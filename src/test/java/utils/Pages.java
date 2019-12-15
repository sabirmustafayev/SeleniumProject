package utils;

import pages.*;

public class Pages {
    private LoginPage loginPage;
    private CreateCarPage createCarPage;
    private CalendarEventPage calendarEventPage;
    private CreateCalendarEventPage createCalendarEventPage;
    private VehiclesPage vehiclesPage;

    public LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

   public CreateCarPage createCarPage(){
        if(createCarPage == null){
            createCarPage = new CreateCarPage();
        }
        return createCarPage;
   }

   public CalendarEventPage calendarEventPage(){
        if(calendarEventPage == null){
            calendarEventPage = new CalendarEventPage();
        }
        return calendarEventPage;
   }

   public CreateCalendarEventPage createCalendarEventPage(){
        if(createCalendarEventPage == null){
            createCalendarEventPage = new CreateCalendarEventPage();
        }
        return createCalendarEventPage;
   }

   public VehiclesPage vehiclesPage(){
       if(vehiclesPage == null){
           vehiclesPage = new VehiclesPage();
       }
       return vehiclesPage;
   }
}
