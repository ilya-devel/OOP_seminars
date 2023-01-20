package sem3.tsk4;

//import java.util.function.Predicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> obj = x -> x > 0;
        System.out.println(obj.test(5));
        System.out.println(obj.test(-4));
    }
}
