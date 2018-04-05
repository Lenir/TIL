import java.util.Date;

public class PrivateEvent implements ScheduleEvent {
    PrivateEvent(String name, Date date){
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isLegalHoliday() {
        return Boolean.TRUE;
    }

    public String toString(){
        return ":: " + name + " at " + date.getYear() + ". " + date.getMonth() + ". " + date.getDate() + ".";
    }

    String name;
    Date date;
}
