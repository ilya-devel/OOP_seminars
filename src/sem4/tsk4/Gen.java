package sem4.tsk4;

public class Gen<T> implements Contain<T> {
    T[] array;

    Gen(T[] o) {
        array = o;
    }

    @Override
    public boolean contains(Object o) {
        for (T x : array) {
            if (x.equals(o)) return true;
        }
        return false;
    }
}
