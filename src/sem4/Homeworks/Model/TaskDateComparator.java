package sem4.Homeworks.Model;

import java.util.Comparator;

public class TaskDateComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getRunDate() == null) return -1;
        if (o2.getRunDate() == null) return 1;
        return o1.getRunDate().compareTo(o2.getRunDate());
    }
}
