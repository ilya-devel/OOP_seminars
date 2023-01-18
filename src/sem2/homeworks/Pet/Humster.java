package sem2.homeworks.Pet;

public class Humster extends Animal {
    Humster(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Pi-Pi-Pi");
    }

    @Override
    public void rumbling() {
        System.out.println("Shi-shi-shi");
    }
}
