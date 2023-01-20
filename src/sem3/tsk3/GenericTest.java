package sem3.tsk3;

public class GenericTest {
    public static void main(String[] args) {
        ISomeTest<Integer> isFactor1 = (a, b) -> (a % b) == 0;
        if (isFactor1.test(10, 2)) System.out.println("2 del 10");
        if (!isFactor1.test(10, 3)) System.out.println("4 del 10");

        System.out.println();

        ISomeTest<Double> isFactor2 = (a, b) -> (a % b) == 0;
        if (isFactor2.test(10d, 2d)) System.out.println("2 del 10");
        if (!isFactor2.test(10d, 3.3)) System.out.println("4 del 10");

        System.out.println();

        ISomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
        String str = "Common functional interface";
        System.out.println("Test string: " + str);
        if (isIn.test(str, "func")) System.out.println("Found");
        else System.out.println("Unfound");
        if (isIn.test(str, "mix")) System.out.println("Found");
        else System.out.println("Unfound");
    }
}
