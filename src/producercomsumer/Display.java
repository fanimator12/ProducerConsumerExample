package producercomsumer;

public class Display implements Runnable {

    private WashingHall washingHall;

    public Display(WashingHall washingHall){
        this.washingHall = washingHall;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Number of free washing places: " +
                    washingHall.getFreePlaces());
        }
    }
}

