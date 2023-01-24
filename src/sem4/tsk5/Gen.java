package sem4.tsk5;


public class Gen {
    private int sum;

    <R extends Number> Gen(R arg) {
        this.sum = 0;
        for (int i = 0; i <= arg.intValue(); i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
