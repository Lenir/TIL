import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        String configLocation = "classpath:applicationCTX.xml";
        AbstractApplicationContext context = new GenericXmlApplicationContext(configLocation);

        ScheduleBook book = context.getBean("scheduleBook", ScheduleBook.class);
        ScheduleEvent event_christmas = context.getBean("event", ScheduleEvent.class);
        Date christmas = context.getBean("date", Date.class);
        christmas.setYear(2018);
        christmas.setMonth(12);
        christmas.setDate(25);

        event_christmas.setDate(christmas);
        event_christmas.setName("2018 CHRISTMAS");

        book.pushEvent(event_christmas);

        book.printEvents();


    }
}
