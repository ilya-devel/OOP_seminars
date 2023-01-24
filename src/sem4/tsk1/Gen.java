package sem4.tsk1;

public class Gen<T> {
    T obi;
    Gen(T o) {
        this.obi = o;
    }

    public T getObi() {
        return obi;
    }
    void showType() {
        System.out.println("Type <T> is: " + this.obi.getClass().getName());
    }
}
