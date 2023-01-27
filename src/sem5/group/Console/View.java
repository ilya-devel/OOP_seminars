package sem5.group.Console;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public double getValue(String msg) {
        System.out.print("Enter value " + msg + " > ");
        return in.nextDouble();
    }

    public void showValue(String msg, double value) {
        System.out.println(msg + value);
    }

    public int getChoice() {
        System.out.println("Choice operation:");
        System.out.println("\t1. Summarize");
        System.out.println("\t2. Subtraction");
        System.out.println("\t3. Multiplication");
        System.out.println("\t4. Division");
        return in.nextInt();
    }
}
