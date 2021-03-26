package producercomsumer;

public class WashingHallTest {
    public static void main(String[] args){
        WashingHall washingHall = new WashingHall(3);
        Display runnableDisplay = new Display(washingHall);

        Thread displayThread = new Thread(runnableDisplay);
        displayThread.start();

        for(int i = 0; i < 20; i++){
            Car car = new Car(washingHall);
            Thread carThread = new Thread(car);
            carThread.start();
        }
    }
}
