import java.util.ArrayList;

public class hourSheet {
    private int hour;
    private int workers;

    hourSheet(int hour, int workers){
        this.hour = hour;
        this.workers = workers;
    }

    public int getHour(){
        return this.hour;
    }

    public void setHour(int hour){
        this.hour = hour;
    }


    public int getWorkers(){
        return this.workers;
    }

    public void setWorkers(int workers){
        this.workers = workers;
    }



}
