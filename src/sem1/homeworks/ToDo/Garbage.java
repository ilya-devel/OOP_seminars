package sem1.homeworks.ToDo;

import java.util.LinkedList;

public class Garbage {
    LinkedList<String> items = new LinkedList<>();

    Garbage (LinkedList<String> items) {
        this.items.addAll(items);
    }
}
