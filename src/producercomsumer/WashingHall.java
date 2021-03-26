package producercomsumer;

import utility.collection.ArrayQueue;
import utility.collection.QueueADT;

public class WashingHall {
    private QueueADT<Hall> availableHalls;
    private int occupiedHalls;
    private boolean queueChanged;

    public WashingHall(int numWashingHalls){
        this.availableHalls = new ArrayQueue<>(numWashingHalls);
        queueChanged = false;

        for(int i = 0; i < numWashingHalls; i++){
            this.availableHalls.enqueue(new Hall(i));
        }
    }

    //A customer enter for washing the car
    //Waits if all the washing places are occupied

    public synchronized Hall enterForWashing(){
        while (availableHalls.isEmpty()){
            try{
                wait();
            } catch (InterruptedException ie){
                //handle ie
            }
        }
        Hall hall = availableHalls.dequeue();
        queueChanged = true;
        occupiedHalls++;
        notifyAll();
        return hall;
    }

    // Car has finished washing
    // Customer leaves for other cars to enter

    public synchronized void leaveAfterWashing(Hall hall){
        while(availableHalls.isFull()){
            try{
                wait();
            } catch(InterruptedException ie){
                // handle ie
            }
        }
        availableHalls.enqueue(hall);
        queueChanged = true;
        occupiedHalls--;
        notifyAll();
    }

    public synchronized int getFreePlaces(){
        while(!queueChanged){
            try{
                wait();
            } catch (InterruptedException ie){
                // handle ie
            }
        }
        queueChanged = false;
        int freePlaces = availableHalls.size();
        notifyAll();
        return freePlaces;
    }
}
