package sem1.homeworks.ToDo;

public class Person {
    String name;

    void iThink(Object obj) {
//        System.out.println(obj.getClass());
        if (obj.getClass().getName().endsWith("Closet")) {
            ((Closet) (obj)).youCanDo();
        }
    }

}
