package sem1.homeworks.pets;

public class Cat extends Animal{

    Cat(String name) {
        super(name);
    }

    @Override
    public void happy() {
        System.out.println("Mr-r-r-r :)");
    }

    @Override
    public void eat() {
        System.out.println("I am eating, meow");
    }

    @Override
    public void walk() {
        System.out.println("I am walking, meow");
    }
}
