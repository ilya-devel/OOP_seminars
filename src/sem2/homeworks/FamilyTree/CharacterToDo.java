package sem2.homeworks.FamilyTree;

public interface CharacterToDo {
    void showInfo();
    void married(Character helpmate);
    void birthChild(String name, Gender gender);
    void showBrothersAndSisters();
    void findParent(Character parent);
}
