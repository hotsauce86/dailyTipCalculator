import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;
public class tipCalculator {

    //workers with their times and tips given
    static ArrayList<worker> tipSheet = new ArrayList<>();

    //shows statistics of expected tip income and working employees
    static ArrayList<hourSheet> hourSheetslist = new ArrayList<>();

    //example list if we had knowledge of how many tips we have
    static ArrayList<actualTips> exampleTips = new ArrayList<>();

    //used to add all the tips before a new employee starts their shift
    //and modify the expected tipRate
    static ArrayList<Bucket> BucketForTips = new ArrayList<>();


    public static void main(String args[]){

        /*
                PRE-DETERMINDED TIPS TEST CASE

                in this section, the tips per hour to the store are given.
                all but one of the workers should post accurate tips, with
                someone taking extra cash for themselves, reducing the pay
                for the other workers

                Payout should follow the amount of tips made per hour for each
                worker on shift, with more workers splitting the value up more
         */
        //3am
        actualTips tips1 = new actualTips(3,2.00f);    exampleTips.add(tips1);
        actualTips tips2 = new actualTips(4,3.00f);    exampleTips.add(tips2);
        actualTips tips3 = new actualTips(5,2.00f);    exampleTips.add(tips3);
        //6am
        actualTips tips4 = new actualTips(6,3.50f);    exampleTips.add(tips4);
        actualTips tips5 = new actualTips(7,4.00f);    exampleTips.add(tips5);
        actualTips tips6 = new actualTips(8,5.00f);    exampleTips.add(tips6);
        //9am
        actualTips tips7 = new actualTips(9,6.00f);    exampleTips.add(tips7);
        actualTips tips8 = new actualTips(10,7.25f);    exampleTips.add(tips8);
        actualTips tips9 = new actualTips(11,8.75f);    exampleTips.add(tips9);
        //12pm
        actualTips tips10 = new actualTips(12,4.00f);   exampleTips.add(tips10);
        actualTips tips11 = new actualTips(13,3.25f);   exampleTips.add(tips11);
        actualTips tips12 = new actualTips(14,4.00f);   exampleTips.add(tips12);
        //3pm 15
        actualTips tips13 = new actualTips(15,3.00f);   exampleTips.add(tips13);
        actualTips tips14 = new actualTips(16,4.50f);   exampleTips.add(tips14);
        actualTips tips15 = new actualTips(17,5.00f);   exampleTips.add(tips15);
        //6pm 18
        actualTips tips16 = new actualTips(18,2.00f);   exampleTips.add(tips16);
        actualTips tips17 = new actualTips(19,0.00f);   exampleTips.add(tips17);
        actualTips tips18 = new actualTips(20,0.00f);   exampleTips.add(tips18);


        //random value generator needs fixing
        for (int i = 0; i <18; i ++){
            Random rand = new Random();

            float x = 3+rand.nextFloat()*(15-3);
          //  exampleTips.add(x);

        }

        for (actualTips temp : exampleTips){
            System.out.println(temp.getHour()+"---"+temp.getTips());
        }

        /*
        //OLD test case for workers with someone taking extra tips?

        worker someWorker1 = new worker(0,3,9,(float)   11.17);//check
        worker someWorker2 = new worker(1,6,15,(float)  16.25);
        worker someWorker3 = new worker(2,6,12,(float)  12.50);
        worker someWorker4 = new worker(3,10,12,(float) 7.75);
        worker someWorker5 = new worker(4,12,16,(float) 4.75);
        worker someWorker6 = new worker(5,12,20,(float) 10.50);
        worker someWorker7 = new worker(6,15,20,(float) 6.75);
         */

        //test case for workers with ACCURATE TIPS



        /*
        worker someWorker8 = new worker(7, 6,12, (float)15);
        worker someWorker9 = new worker(8, 6, 12, (float)15);

        tipSheet.add(someWorker8);
        tipSheet.add(someWorker9);

        workersPerHour(1);
        compareWorkerToStoreTips( someWorker8);
        compareWorkerToStoreTips( someWorker9);
        */


        worker someWorker1 = new worker(0,3,9,(float)   11.17);//check
        worker someWorker2 = new worker(1,6,15,(float)  15.92);
        worker someWorker3 = new worker(2,6,12,(float)  12.50);
        worker someWorker4 = new worker(3,10,14,(float) 7.15);  //fixed 4 hour shift
        worker someWorker5 = new worker(4,12,16,(float) 4.15);
        worker someWorker6 = new worker(5,12,20,(float) 9.89);
        worker someWorker7 = new worker(6,15,20,(float) 6.75);

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
        compareWorkerToStoreTips( someWorker1);
        compareWorkerToStoreTips( someWorker2);
        compareWorkerToStoreTips( someWorker3);
        compareWorkerToStoreTips( someWorker4);
        compareWorkerToStoreTips( someWorker5);
        compareWorkerToStoreTips( someWorker6);
        compareWorkerToStoreTips( someWorker7);

        BucketFiller2();

    }
    //////////////////////////////////////////////////END OF MAIN//////////////////////////////////////////////////////
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

        for (int i = workerStart; i <workerEnd; i++){
            weird +=  workerTipRate(someWorker)-hourSheetslist.get(i-3).getTipsRate()/hourSheetslist.get(i-3).getWorkers();
           // System.out.println("the difference values: " +hourSheetslist.get(i-3).getTipsRate()/hourSheetslist.get(i-3).getWorkers()+"_-_"+workerTipRate(someWorker)+ ", weird: " +weird);
            //System.out.println("result; " +weird);
        }
        //if a values is off from the expected amount
        if(weird < -1.5 || weird > 1.5){
            System.out.println(" WARNING: " +weird);
        }
        else
        System.out.println(" weird: " +weird);
        //System.out.println(weird);

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

        }
        System.out.println("numbers of hours in the work day: " +hourSheetslist.size());

        float sumOfAveTips=0;
        for(int k=0; k < hourSheetslist.size(); k++){
            sumOfAveTips += hourSheetslist.get(k).getTipsRate();
            System.out.println("hour:  " +   hourSheetslist.get(k).getHour()+ '\t'+
                    ",  #OfWorkers: "+     hourSheetslist.get(k).getWorkers()+ '\t'+
                    ",  Ave Tip: "+          hourSheetslist.get(k).getTipsRate() + '\t'+
                    ",  TipsTotal: " +        hourSheetslist.get(k).getTipTotal());
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

    public static void BucketFiller2(){
        boolean addToBucket =false;
        float tipsInBucket=0;

        for(actualTips temp : exampleTips){
            for(worker sheet: tipSheet){
                if(sheet.getStartHour()==temp.getHour()){
                    addToBucket = true;
                }
                if(sheet.getEndHour() == temp.getHour()){
                    addToBucket = true;
                }
            }
            tipsInBucket += temp.getTips();
            if(addToBucket==true){
                Bucket someBucket = new Bucket(temp.getHour(), tipsInBucket);
                BucketForTips.add(someBucket);
                tipsInBucket=0;
                addToBucket=false;
            }
        }
        for( Bucket temp : BucketForTips){
            System.out.println(temp.getTimeFilled()+": "+temp.getGatheredTips());
        }
    }
    public static void BucketFiller(){
        int currentWorkers =0;
        float currentTotalTips=0;
        int hoursToLoop=0;
        int lastLoopHour;
        for (hourSheet temp : hourSheetslist){
            if(temp.getWorkers() != currentWorkers){
                for(actualTips theseExampleTips: exampleTips){
                    if(theseExampleTips.getHour() < hoursToLoop){
                        currentTotalTips += theseExampleTips.getTips();
                    }
                }
                Bucket bucks = new Bucket(temp.getHour(), currentTotalTips);
                BucketForTips.add(bucks);
                currentTotalTips =0;
                currentWorkers=temp.getWorkers();
            }
            if(temp.getHour()==19){
                for(actualTips theseExampleTips: exampleTips){
                    if(theseExampleTips.getHour() < hoursToLoop){
                        currentTotalTips += theseExampleTips.getTips();
                    }
                }
                Bucket bucks = new Bucket(temp.getHour(), currentTotalTips);
                BucketForTips.add(bucks);
            }
            hoursToLoop++;
        }
        for( Bucket temp : BucketForTips){
            System.out.println(temp.getTimeFilled()+": "+temp.getGatheredTips());
        }
    }




}
