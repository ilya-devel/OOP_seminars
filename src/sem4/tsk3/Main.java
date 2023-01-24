package sem4.tsk3;

public class Main {
    public static void main(String[] args) {
        Numeric<Integer> num1 = new Numeric<>(6);
        System.out.println(num1.getNum());
        System.out.println(num1.getReg());
        System.out.println(num1.getFrac());

        System.out.println();

        Numeric<Double> num2 = new Numeric<>(-6d);
        System.out.println(num2.getNum());
        System.out.println(num2.getReg());
        System.out.println(num2.getFrac());

        System.out.println();

        Numeric<Long> num3 = new Numeric<>(5L);

        System.out.println("num1 equals num2: " + num1.absEqual(num2));
        System.out.println("num1 equals num3: " + num1.absEqual(num3));

    }
}
