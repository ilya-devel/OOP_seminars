package sem2.homeworks.Pet;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Rex");
        Humster humster = new Humster("Ricki");
        AnimalToDo link = cat;
        link.eat();
        link.rumbling();
        link.voice();
        System.out.println();
        link = dog;
        link.eat();
        link.rumbling();
        link.voice();
        System.out.println();
        link = humster;
        link.eat();
        link.rumbling();
        link.voice();
    }
}
