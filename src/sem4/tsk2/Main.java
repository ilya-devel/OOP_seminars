package sem4.tsk2;

public class Main {
    public static void main(String[] args) {
        Gen<Integer, String> obj1 = new Gen<>(666, "Satan");
        obj1.showTypes();
        int val1 = obj1.getObj1();
        String val2 = obj1.getObj2();
        System.out.println("Values obj1.obj1 equals " + val1);
        System.out.println("Values obj1.obj2 equals " + val2);
    }
}
