import java.util.Date;

public class Holiday implements ScheduleEvent {
    Holiday(String name, Date date){
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
        this.date = new Date(date.getYear(), date.getMonth(), date.getDate());
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isLegalHoliday() {
        return Boolean.FALSE;
    }

    @Override
    public String toString(){
        return ":: < Holiday > " + name + " at " + date.getYear() + ". " + date.getMonth() + ". " + date.getDate() + ".";
    }

    String name;
    Date date;
}
