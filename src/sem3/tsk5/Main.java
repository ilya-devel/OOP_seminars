package sem3.tsk5;


public class Main {
    public static void main(String[] args) {
        IBinaryOperation<Integer> obj = (x, y) -> x * y;
        System.out.println(obj.apply(12,3));
        System.out.println(obj.apply(5,3));
    }
}
