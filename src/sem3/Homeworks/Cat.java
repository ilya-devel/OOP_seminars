package sem3.Homeworks;

public class Cat implements Comparable<Cat> {
    private final String name;
    private final int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Cat o) {
        return (this.age - o.getAge()) + (this.getName().compareTo(o.getName()));
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

