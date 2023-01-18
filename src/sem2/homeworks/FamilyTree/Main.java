package sem2.homeworks.FamilyTree;


public class Main {
    public static void main(String[] args) {
        Person tst = new Person("Ilya", Gender.Female);
        Person mother = new Person("Yuliya", Gender.Female);
        Person father = new Person("Alfat", Gender.Male);
        Person helpmate = new Person("Mara", Gender.Female);
        CharacterToDo t = tst;
        t.birthChild("Marry", Gender.Female);
        t.birthChild("Jack", Gender.Male);
        t.birthChild("Anna", Gender.Female);
        t.findParent(mother);
        t.findParent(father);
        t.married(helpmate);
        t.showInfo();
        System.out.println();
        CharacterToDo c = tst.getChildren().get(0);
        c.showInfo();
    }
}
