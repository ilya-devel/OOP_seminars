package sem1.homeworks.pets;

abstract class Animal implements AnimalActions {
    private String name;

    Animal (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
