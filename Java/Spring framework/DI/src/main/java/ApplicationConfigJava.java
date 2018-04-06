import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;

@Configuration
public class ApplicationConfigJava {

    @Bean
    public ScheduleBook scheduleBook(){
        ScheduleBook scheduleBook = new ScheduleBook();
        return scheduleBook;
    }

    @Bean
    public Holiday event_christmas(){
        Calendar date = dateChristmas2018();
        Holiday holiday = new Holiday("2018 Christmas", date);
        return holiday;
    }

    @Bean
    public Calendar dateChristmas2018(){
        Calendar date = Calendar.getInstance();
        date.set(2018, 11, 25);
        return date;
    }

}
