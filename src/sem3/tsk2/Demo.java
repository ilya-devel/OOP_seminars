package sem3.tsk2;

public class Demo {
    public static void main(String[] args) {
        IInter test = (n) -> {
            int result = 1;
            n = n < 0 ? -n : n;
            for (int i = 2; i < n / i; i++) {
                if ((n % i) == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        };
        System.out.println("Smallest delimetr of 12 equals " + test.func(12));
        System.out.println("Smallest delimetr of 11 equals " + test.func(11));
    }
}
