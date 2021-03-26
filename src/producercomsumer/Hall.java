package producercomsumer;

public class Hall {
    private int num;

    public Hall(int num) {
    this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Hall " + num;
    }
}
