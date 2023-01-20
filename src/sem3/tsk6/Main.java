package sem3.tsk6;

public class Main {
    public static void main(String[] args) {
        IUnaryOperator<Integer> obj = x -> x * x;
        System.out.println(obj.apply(100));
    }
}
