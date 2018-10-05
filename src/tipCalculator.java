import java.util.ArrayList;

public class tipCalculator {

    static ArrayList<worker> tipSheet = new ArrayList<>();

    static ArrayList<hourSheet> hourSheetslist = new ArrayList<>();

    public static void main(String args[]){

        worker someWorker1 = new worker(0,3,9,(float)24.57);
        worker someWorker2 = new worker(1,6,15,(float)33.27);
        worker someWorker3 = new worker(2,6,12,(float)16.77);
        worker someWorker4 = new worker(3,10,12,(float)19.44);
        worker someWorker5 = new worker(4,12,16,(float)12.82);
        worker someWorker6 = new worker(5,12,20,(float)11.74);
        worker someWorker7 = new worker(6,15,20,(float)10.51);


        tipSheet.add(someWorker1);
        tipSheet.add(someWorker2);
        tipSheet.add(someWorker3);
        tipSheet.add(someWorker4);
        tipSheet.add(someWorker5);
        tipSheet.add(someWorker6);
        tipSheet.add(someWorker7);


        System.out.println("Size of the tip sheet: "+tipSheet.size());
        workersPerHour(1);
        System.out.println("worker 1 tips per hour: "+ workerTipRate(someWorker2));

        System.out.println((workerTipRate(someWorker1)+workerTipRate(someWorker2)+workerTipRate(someWorker3)));

        compareWorkerToStoreTips( someWorker7);

    }
    /*
        compareWorkerToStoreTips

        This shows the difference from what the store hourly tip rate is from what the recorded workers hourly tip rate
        a diffence +/- 2 dollars should stand out as an error or a sign that someone is cheating on tips

        this is currently one hour, needs to apply to all hours worked

     */
    public static void compareWorkerToStoreTips( worker someWorker){
        int workerStart = someWorker.getStartHour();
        int workerEnd = someWorker.getEndHour();
        float weird=0;

        for (int i = workerStart; i <=workerEnd; i++){
            weird += hourSheetslist.get(i-3).getTipsRate()/hourSheetslist.get(i-3).getWorkers()-workerTipRate(someWorker);
            System.out.println(hourSheetslist.get(i-3).getTipsRate()/hourSheetslist.get(i-3).getWorkers()+"_-_"+workerTipRate(someWorker));
            System.out.println(weird);
        }
        System.out.println(weird);

    }

    public static void workersPerHour(int somevalue){
        int numOfWorkers =0;
        float aveTipsThisHour=0;
        float totaltipsperhour=0;
        for(int i =3; i<=20; i++){
           // aveTipsThisHour =0 ;
            //adds or subtracts the number of workers in a hour during the work day
            for(int j = 0; j < tipSheet.size(); j++){

                if (tipSheet.get(j).getStartHour() == i){
                    numOfWorkers++;
                    aveTipsThisHour += workerTipRate(tipSheet.get(j));

                }
                if (tipSheet.get(j).getEndHour() == i){
                    numOfWorkers--;
                    aveTipsThisHour -= workerTipRate(tipSheet.get(j));
                    totaltipsperhour += tipSheet.get(j).getTips();
                }


            }
            if(i == 20){
                numOfWorkers= hourSheetslist.get(hourSheetslist.size()-1).getWorkers();
            }

            hourSheet workersThisHour = new hourSheet(i, numOfWorkers, aveTipsThisHour, totaltipsperhour);
            hourSheetslist.add(workersThisHour);
            System.out.println("_____-----_____");

        }
        System.out.println("numbers of hours in the work day: " +hourSheetslist.size());

        float sumOfAveTips=0;
        for(int k=0; k < hourSheetslist.size(); k++){
            sumOfAveTips += hourSheetslist.get(k).getTipsRate();
            System.out.println("hour: " + hourSheetslist.get(k).getHour()+ ", # of workers: "+
                    hourSheetslist.get(k).getWorkers()+", Ave Tip: "+
                    hourSheetslist.get(k).getTipsRate() + " TipsTotal: " +
                    hourSheetslist.get(k).getTipTotal());
        }
        System.out.println("Expected tips: "+ sumOfAveTips+", Actual tips: "+totaltipsperhour);

    }

    public static float workerTipRate(worker someworker){
        int hoursWorked = someworker.getEndHour()-someworker.getStartHour();
        float tipTotal = someworker.getTips();

        //tip rate for the single employee
        float tipRate = tipTotal/hoursWorked;
        return tipRate;
    }






}
