import java.util.ArrayList;
import java.util.Calendar;

public class ScheduleBook {
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
                System.out.println(":: " + event.getName() + " at " + event.getDate().toString());
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
}
