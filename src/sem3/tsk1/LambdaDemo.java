package sem3.tsk1;

public class LambdaDemo {
    public static void main(String[] args) {
        I_NumericTest isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2)) System.out.println("2 is delimtr 10");
        if (!isFactor.test(10, 3)) System.out.println("3 isn't delimtr 10");

        System.out.println();

        I_NumericTest isFactor2 = (n, m) -> (n < m);
        if (isFactor2.test(2, 10)) System.out.println("2 less 10");
        if (!isFactor2.test(10, 2)) System.out.println("10 isn't less 2");

        System.out.println();

        I_NumericTest abcEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
        if (abcEqual.test(4,-4)) System.out.println("4 and -4 is equals");
        if (!abcEqual.test(4, -5)) System.out.println("4 and -5 is not equals");
    }
}
