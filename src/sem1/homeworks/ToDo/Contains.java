package sem1.homeworks.ToDo;

import java.util.LinkedList;

abstract class Contains {
    LinkedList<String> items = new LinkedList<>();

    void viewContent () {
        System.out.println("In the closet:");
        for (String item :
                this.items) {
            System.out.println("\t" + item);
        }
    }

    void putIn (String item) {
        System.out.println("You put " + item + " in the closet");
        this.items.add(item);
    }
    void getOut (String item) {
        System.out.println("You took " + item + " from the closet");
        this.items.remove(item);
    }
    Garbage destroyContain() {
        System.out.println("You destroed closet");
        return new Garbage(this.items);
    }
}

