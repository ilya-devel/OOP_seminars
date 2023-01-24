package sem4.tsk4;


public class Main {
    public static void main(String[] args) {
        Integer[] x = {1, 2, 3, 4};
        Gen<Integer> obj = new Gen<>(x);
        System.out.println("1 in obj? " + obj.contains(1));
        System.out.println("5 in obj? " + obj.contains(5));
    }
}
