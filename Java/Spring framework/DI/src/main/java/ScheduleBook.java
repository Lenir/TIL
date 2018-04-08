import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.Calendar;

public class ScheduleBook implements InitializingBean, DisposableBean{
    ScheduleBook(){
        events = new ArrayList<ScheduleEvent>();
    }

    void pushEvent(ScheduleEvent event){
        events.add(event);
    }

    void printEvents(){
        if(events.isEmpty()){
            System.out.println(":: There are no events.");
        }else {
            for (ScheduleEvent event : events) {
                System.out.println(event.toString());
            }
        }

    }

    void deleteEvent(Calendar date){
        // It's just for practice. So I impelemented with linear search.
        for(int index = events.size()-1; index <= 0; index--){
            if(events.get(index).getDate().equals(date)){
                events.remove(index);
            }
        }
    }

    ArrayList<ScheduleEvent> events;

    public void destroy() throws Exception {
        System.out.println("< ScheduleBook > Destroy bean");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("< ScheduleBook > Bean properties are set");
    }
}
