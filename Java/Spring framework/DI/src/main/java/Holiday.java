import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Calendar;
import java.util.Date;

public class Holiday implements ScheduleEvent {
    Holiday(String name, Calendar date){
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
        return Boolean.FALSE;
    }

    @Override
    public String toString(){
        return ":: < Holiday > " + name + " at " + date.get(Calendar.YEAR) + ". " + (date.get(Calendar.MONTH)+1) + ". " + date.get(Calendar.DATE);
    }

    @PostConstruct
    public void initMethod_withAnnotation() throws Exception {
        System.out.println("< Holiday > " + name + " bean properties are set.");
    }

    @PreDestroy
    public void destroyMethod_withAnnotation() throws Exception {
        System.out.println("< Holiday > Destroy " + name + " bean.");
    }


    String name;
    Calendar date;
}
