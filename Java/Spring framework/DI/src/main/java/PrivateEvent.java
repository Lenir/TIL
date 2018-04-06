import java.util.Calendar;
import java.util.Date;

public class PrivateEvent implements ScheduleEvent {
    PrivateEvent(String name, Calendar date){
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isLegalHoliday() {
        return Boolean.TRUE;
    }

//    public String toString(){
//        return ":: " + name + " at " + date.getYear() + ". " + date.getMonth() + ". " + date.getDate() + ".";
//    }

    String name;
    Calendar date;
}
