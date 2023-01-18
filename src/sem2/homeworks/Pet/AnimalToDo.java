package sem2.homeworks.Pet;

public interface AnimalToDo {
    void voice();
    void rumbling();

    default void eat() {
        System.out.println("animal eat");
    }
}
