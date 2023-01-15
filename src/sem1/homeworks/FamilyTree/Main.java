package sem1.homeworks.FamilyTree;

public class Main {
    public static void main(String[] args) {
        Person me = new Person("Ilya", Gender.Female);
        Person mother = new Person("Yuliya", Gender.Female);
        Person father = new Person("Alfat", Gender.Male);

        me.setMother(mother);
        me.setFather(father);
        me.getMother().married(me.getFather());

        me.getMother().birthChild(new Person("Ruslan", Gender.Male));

//        me.showParents();
//        me.yourBrothersAndSisters();

        me.showInfo();
        me.getMother().showInfo();
        me.getFather().showInfo();

        me.showFamilyTree();
    }
}
