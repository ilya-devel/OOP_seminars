package sem4.Homeworks.Model;

import java.util.Comparator;

public class TaskIdComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getIdTask() > o2.getIdTask()) return 1;
        if (o1.getIdTask() < o2.getIdTask()) return -1;
        return 0;
    }
}

