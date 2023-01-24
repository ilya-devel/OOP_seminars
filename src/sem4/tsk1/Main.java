package sem4.tsk1;

public class Main {
    public static void main(String[] args) {
        Gen<Integer> obj = new Gen<>(88);
        obj.showType();
        int v = obj.getObi();
        System.out.println("Values: " + v);

        System.out.println();

        Gen<String> str = new Gen<>("Testing");
        str.showType();
        String txt = str.getObi();
        System.out.println("Values: " + txt);

    }
}
