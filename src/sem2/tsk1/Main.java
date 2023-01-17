package sem2.tsk1;

public class Main {
    public static void main(String[] args) {
        TestFirst obj1 = new TestFirst();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj1.getNext());
        }
        System.out.println("Reset");
        obj1.reset();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj1.getNext());
        }
        System.out.println("Start values equal 100");
        obj1.setStart(100);
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj1.getNext());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Previous values " + obj1.getPreview());
        }

        TestSecond obj2 = new TestSecond();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj2.getNext());
        }
        System.out.println("Reset");
        obj2.reset();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj2.getNext());
        }
        System.out.println("Start values equal 100");
        obj2.setStart(100);
        for (int i = 0; i < 5; i++) {
            System.out.println("Next values " + obj2.getNext());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Previous values " + obj2.getPreview());
        }

        GetNums obj3;
        for (int i = 0; i < 5; i++) {
            obj3 = obj1;
            System.out.println("Next values " + obj3.getNext());
            System.out.println("==========================");
            obj3 = obj2;
            System.out.println("Next values " + obj3.getNext());
            System.out.println();
        }
    }
}
