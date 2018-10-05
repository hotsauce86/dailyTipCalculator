public class worker {

    private int workerID;

    private int startHour;
    private int endHour;

    private float tips;

    worker (int workerID, int startHour, int endHour, float tips){
        this.workerID = workerID;
        this.startHour = startHour;
        this.endHour = endHour;
        this.tips = tips;
    }

    // worker
    public int getWorkerID() {
        return this.workerID;
    }

    public void setWorkerID(int workerID){
        this.workerID = workerID;
    }

    //start shift
    public int getStartHour(){
        return this.startHour;
    }

    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    //end shift
    public int getEndHour(){
        return this.endHour;
    }

    public void setEndHour(int endHour){
        this.endHour =  endHour;
    }

    //tips
    public float getTips() {
        return this.tips;
    }

    public void setTips(float tips){
        this.tips = tips;
    }

}
