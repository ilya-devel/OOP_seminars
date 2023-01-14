package sem1.tsk3;

public class Animals {
    private String name;

    void speak() {
        System.out.println("I don't speak");
    }

    public String getName() {
        return this.name;
    }
}

class Cat extends Animals {
    @Override
    void speak() {
        System.out.println("Mya-Mya");
    }
}

class Testing {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.speak();
        Animals animals = new Animals();
        animals.speak();
    }
}