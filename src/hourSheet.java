import java.util.ArrayList;

public class hourSheet {
    private int hour;
    private int workers;
    private float tipsRate;
    private float tipTotal;

    hourSheet(int hour, int workers, float tipsRate, float tipTotal){
        this.hour = hour;
        this.workers = workers;
        this.tipsRate = tipsRate;
        this.tipTotal = tipTotal;
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


    public float getTipsRate(){
        return this.tipsRate;
    }

    public void setTipsRate(float tipsRate){
        this.tipsRate = tipsRate;
    }


    public float getTipTotal(){
        return this.tipTotal;
    }

    public void setTipTotal(float tipTotal){
        this.tipTotal = tipTotal;
    }
}
