package sem3.Homeworks;

import java.util.Comparator;

public class CatAgeComporator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
//        if (o1.getAge() > o2.getAge()) return 1;
//        if (o1.getAge() < o2.getAge()) return -1;
//        return 0;
    }
}
