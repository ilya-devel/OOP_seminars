package sem4.tsk2;

public class Gen<T, V> {
    T obj1;
    V obj2;
    Gen (T o1, V o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }
    void showTypes() {
        System.out.println("Type <T> is " + obj1.getClass().getName());
        System.out.println("Type <V> is " + obj2.getClass().getName());
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }
}
