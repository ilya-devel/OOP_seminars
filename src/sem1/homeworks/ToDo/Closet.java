package sem1.homeworks.ToDo;

import java.util.Scanner;

public class Closet extends Contains{
    String color;

    Closet () {
        super();
        this.color = "Grey";
    }

    void youCanDo () {
        System.out.println("You can do:\n\t1. Put item in the closet\n\t2. Took item from the closet\n\t3. View contents\n\t4. Destroyed the closet");
        Scanner in = new Scanner(System.in);
        String iDo = in.next();
        switch (iDo) {
            case "1" -> {
                System.out.println("Which item?: ");
                String item = in.next();
                this.putIn(item);
            }
            case "2" -> {
                System.out.println("Which item?: ");
                String item2 = in.next();
                this.getOut(item2);
            }
            case "3" -> {
                System.out.println();
                this.viewContent();
            }
            case "4" -> {
                System.out.println();
                this.destroyContain();
            }
            default -> System.out.println("Unknown choice");
        }
    }
}
