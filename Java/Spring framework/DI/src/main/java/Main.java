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

        /*
            Actually, eventChristmas bean is generated by bean container. so getting new bean with same bean name is getting alias.
         */
        ScheduleEvent newYearsDay = context.getBean("eventChristmas", ScheduleEvent.class);
        Calendar newYearsDayCalendar = Calendar.getInstance();
        newYearsDayCalendar.set(2018, 0, 1);
        newYearsDay.setName("New year's day");
        newYearsDay.setDate(newYearsDayCalendar);

        book.pushEvent(newYearsDay);


        book.printEvents();

        try{
            book.destroy();
        }catch (Exception e){
            System.out.println(e);
        }


        // config with java class.
        System.out.println("--------- Java annotation Config ---------");
        AnnotationConfigApplicationContext contextJava = new AnnotationConfigApplicationContext(ApplicationConfigJava.class);

        ScheduleBook bookJava = contextJava.getBean("scheduleBook", ScheduleBook.class);
        ScheduleEvent eventChristmasJava = contextJava.getBean("event_christmas", ScheduleEvent.class);

        bookJava.pushEvent(eventChristmasJava);

        /*
            Same. eventChristmas bean is generated by bean container. so getting new bean with same bean name is getting alias.
         */
        ScheduleEvent newYearsDayJava = contextJava.getBean("event_christmas", ScheduleEvent.class);
        Calendar newYearsDayJavaCalendar = Calendar.getInstance();
        newYearsDayJavaCalendar.set(2018, 0, 1);
        newYearsDayJava.setName("New year's day");
        newYearsDayJava.setDate(newYearsDayJavaCalendar);

        bookJava.pushEvent(newYearsDayJava);


        bookJava.printEvents();

        try{
            bookJava.destroy();
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
