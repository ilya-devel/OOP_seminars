package sem3.Homeworks;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 7);
        Cat cat2 = new Cat("Lutic", 7);
        Cat cat3 = new Cat("Alice", 2);
        Cat cat4 = new Cat("Shiro", 24);
        Cat cat5 = new Cat("Vasilyok", 12);
        TreeSet<Cat> tree = new TreeSet<>();
        tree.add(cat1);
        tree.add(cat2);
        tree.add(cat3);
        tree.add(cat4);
        tree.add(cat5);
        for (Cat cat : tree) {
            System.out.println(cat.getName() + " is " + cat.getAge() + " months");
        }

        ICheckCat<Cat> test = (a, b) -> {
            int res = a.getAge() - b.getAge();
            if (res < 0) System.out.println(a.getName() + " is younger");
            if (res > 0) System.out.println(b.getName() + " is younger");
            if (res == 0) System.out.println(a.getName() + " and " + b.getName() + " are the same age");
        };

        System.out.println();

        test.checkCat(cat1, cat2);
        test.checkCat(cat1, cat4);

        System.out.println();
        Comparator<Cat> ccomp = new CatNameComporator().thenComparing(new CatAgeComporator());
        TreeSet<Cat> tree2 = new TreeSet<>(ccomp);
        tree2.add(cat1);
        tree2.add(cat2);
        tree2.add(cat3);
        tree2.add(cat4);
        tree2.add(cat5);
        for (Cat cat : tree2) {
            System.out.println(cat.getName() + " is " + cat.getAge() + " months");
        }
    }
}
