package sem4.tsk3;

public class Numeric<T extends Number> {
    T num;
    Numeric(T n) {
        this.num = n;
    }

    public T getNum() {
        return this.num;
    }

    double getReg() {
        return 1/this.num.doubleValue();
    }
    double getFrac() {
        return this.num.doubleValue() - this.num.intValue();
    }

    boolean absEqual(Numeric<?> obj) {
        return  (Math.abs(this.num.doubleValue()) == Math.abs(obj.getNum().intValue()));
    }
}
