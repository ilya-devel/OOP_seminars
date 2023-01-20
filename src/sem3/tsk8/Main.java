package sem3.tsk8;

public class Main {
    public static void main(String[] args) {
        IConsumer<Integer> print = x -> System.out.printf("%d$\n", x);
        print.accept(666);
    }
}
