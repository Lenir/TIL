import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public interface ScheduleEvent {
    String getName();
    Date getDate();
    void setDate(Date date);
    void setName(String name);
    Boolean isLegalHoliday();
    String toString();


}
