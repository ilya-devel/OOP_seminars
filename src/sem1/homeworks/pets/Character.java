package sem1.homeworks.pets;

public class Character {
    private String name;

    Character(String name) {
        this.name = name;
    }

    void callPet(Animal pet) {
        System.out.println(this.getName() + " calls " + pet.getName());
        System.out.print(pet.getName() + " answer: ");
        pet.walk();
    }
    void feedPet(Animal pet) {
        System.out.println(this.getName() + " feeds " + pet.getName());
        System.out.print(pet.getName() + " answer: ");
        pet.eat();
    }
    void strokesPet(Animal pet) {
        System.out.println(this.getName() + " strokes " + pet.getName());
        System.out.print(pet.getName() + " answer: ");
        pet.happy();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
