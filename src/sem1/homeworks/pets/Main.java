package sem1.homeworks.pets;

public class Main {
    public static void main(String[] args) {
        Character person = new Character("Vera");
        Cat cat = new Cat("Barsik");

        person.callPet(cat);
        System.out.println();
        person.feedPet(cat);
        System.out.println();
        person.strokesPet(cat);
    }
}
