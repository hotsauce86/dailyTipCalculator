import java.util.ArrayList;

public class tipCalculator {

    static ArrayList<worker> tipSheet = new ArrayList<>();

    static ArrayList<hourSheet> hourSheetslist = new ArrayList<>();

    public static void main(String args[]){

        worker someWorker1 = new worker(0,3,9,(float)24.57);
        worker someWorker2 = new worker(1,6,15,(float)33.27);
        worker someWorker3 = new worker(2,6,12,(float)17.74);
        worker someWorker4 = new worker(3,10,12,(float)17.74);
        worker someWorker5 = new worker(4,12,16,(float)17.74);
        worker someWorker6 = new worker(5,12,20,(float)17.74);
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

    }


    public static void workersPerHour(int somevalue){
        int numOfWorkers =0;
        for(int i =3; i<=20; i++){

            for(int j = 0; j < tipSheet.size(); j++){
                if (tipSheet.get(j).getStartHour() == i){
                    numOfWorkers++;
                }
                if (tipSheet.get(j).getEndHour() == i){
                    numOfWorkers--;
                }
            }
            hourSheet workersThisHour = new hourSheet(i, numOfWorkers);
            hourSheetslist.add(workersThisHour);

        }
        System.out.println("numbers of hours in the work day: " +hourSheetslist.size());

        for(int k=0; k < hourSheetslist.size(); k++){
            System.out.println(hourSheetslist.get(k).getHour()+ " "+hourSheetslist.get(k).getWorkers());
        }

    }

    public static float workerTipRate(worker someworker){
        int hoursWorked = someworker.getEndHour()-someworker.getStartHour();
        float tipTotal = someworker.getTips();

        float tipRate = tipTotal/hoursWorked;
        return tipRate;
    }






}
