package producercomsumer;

public class Car implements Runnable {
    private WashingHall washingHall;

    public Car(WashingHall washingHall){
        this.washingHall = washingHall;
    }

    @Override
    public void run() {
        Hall hall = washingHall.enterForWashing();
        System.out.println("Car entered for washing in the hall: " + hall.getNum());

        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){
            // handle ie
        }
        washingHall.leaveAfterWashing(hall);
        System.out.println("Car leaving after washing in the hall: " + hall.getNum());
    }
}

