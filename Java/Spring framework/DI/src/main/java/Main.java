import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        // config with XML file
        System.out.println("--------- XML Config ---------");
        String configLocation = "classpath:applicationCTX.xml";
        AbstractApplicationContext context = new GenericXmlApplicationContext(configLocation);

        ScheduleBook book = context.getBean("scheduleBook", ScheduleBook.class);
        ScheduleEvent eventChristmas = context.getBean("eventChristmas", ScheduleEvent.class);

        book.pushEvent(eventChristmas);
        book.printEvents();

        // config with java class.
        System.out.println("--------- Java annotation Config ---------");
        AnnotationConfigApplicationContext contextJava = new AnnotationConfigApplicationContext(ApplicationConfigJava.class);

        ScheduleBook bookJava = contextJava.getBean("scheduleBook", ScheduleBook.class);
        ScheduleEvent eventChristmasJava = contextJava.getBean("event_christmas", ScheduleEvent.class);

        bookJava.pushEvent(eventChristmasJava);
        bookJava.printEvents();


    }
}
