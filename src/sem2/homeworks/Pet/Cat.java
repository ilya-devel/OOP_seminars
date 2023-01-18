package sem2.homeworks.Pet;

public class Cat extends Animal{

    Cat(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Meow-meow");
    }

    @Override
    public void rumbling() {
        System.out.println("Mr-r-r Mr-r-r");
    }
}
