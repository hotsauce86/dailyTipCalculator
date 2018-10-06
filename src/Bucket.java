public class Bucket {
    private int timeFilled;
    private float gatheredTips;

    Bucket(int timeFilled, float gatheredTips){
        this.timeFilled = timeFilled;
        this.gatheredTips =gatheredTips;
    }

    public int getTimeFilled(){
        return this.timeFilled;
    }

    public void setTimeFilled(int timeFilled){
        this.timeFilled = timeFilled;
    }

    public float getGatheredTips(){
        return this.gatheredTips;
    }

    public void setGatheredTips(float gatheredTips){
        this.gatheredTips = gatheredTips;
    }

}
