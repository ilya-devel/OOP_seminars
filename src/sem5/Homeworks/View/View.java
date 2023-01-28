package sem5.Homeworks.View;

import java.util.Scanner;

public class View implements IView {
    Scanner in = new Scanner(System.in);

    @Override
    public int choiceOperation() {
        System.out.println("Choice operation:");
        System.out.println("\t1. Summarize");
        System.out.println("\t2. Subtraction");
        System.out.println("\t3. Multiplication");
        System.out.println("\t4. Division");
        System.out.println("\t5. Back");
        return in.nextInt();
    }

    @Override
    public int choiceTypeValues() {
        System.out.println("Choice operation:");
        System.out.println("\t1. Rational values");
        System.out.println("\t2. Complex values");
        System.out.println("\t3. Exit");
        return in.nextInt();
    }

    @Override
    public void showResult(String result) {
        System.out.println("Result operation > " + result);
    }
}
