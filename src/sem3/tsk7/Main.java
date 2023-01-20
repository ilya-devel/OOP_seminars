package sem3.tsk7;

public class Main {
    public static void main(String[] args) {
        IFunction<Integer, String> obj = x -> String.valueOf(x) + "$";
        System.out.println(obj.apply(777));
    }
}
