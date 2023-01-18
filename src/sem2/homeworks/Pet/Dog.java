package sem2.homeworks.Pet;

public class Dog extends Animal{
    Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Woof Woof");
    }

    @Override
    public void rumbling() {
        System.out.println("Mr-r-r Mr-r-r");
    }
}
