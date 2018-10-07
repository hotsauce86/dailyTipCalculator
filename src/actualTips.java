public class actualTips {

    private int hour;
    private float tips;

    actualTips(int hour, float tips){
        this.hour =hour;
        this.tips =tips;
    }

    public int getHour(){
        return this.hour;
    }

    public void setHour(int hour){
        this.hour =hour;
    }

    public float getTips(){
        return this.tips;
    }

    public void setTips(float tips){
        this.tips =tips;
    }
}
