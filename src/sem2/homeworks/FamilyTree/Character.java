package sem2.homeworks.FamilyTree;

import java.util.LinkedList;

abstract class Character implements CharacterToDo {
    static int id = 0;

    int id_person;
    protected String name;
    protected Gender gender;
    private Character father;
    private Character mother;
    private Character helpmate;
    protected final LinkedList<Person> children = new LinkedList<>();

    protected void setFather(Character father) {
        this.father = father;
    }

    protected void setMother(Character mother) {
        this.mother = mother;
    }

    protected void setHelpmate(Character helpmate) {
        this.helpmate = helpmate;
    }

    public int getId_person() {
        return id_person;
    }

    public Character getFather() {
        return father;
    }

    public Character getMother() {
        return mother;
    }

    public Character getHelpmate() {
        return helpmate;
    }

    public LinkedList<Person> getChildren() {
        return children;
    }
}
