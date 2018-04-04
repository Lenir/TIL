import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ScheduleEvent {
    ScheduleEvent(String name, Date date){
        eventName = name;
        eventDate = date;
    }

    String getName(){
        return eventName;
    }

    Date getDate(){
        return eventDate;
    }

    void setDate(Date date){
        eventDate = date;
    }

    void setName(String name){
        eventName = name;
    }

    String eventName;
    Date eventDate;
}
