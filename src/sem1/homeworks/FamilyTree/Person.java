package sem1.homeworks.FamilyTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;


enum Gender {Male, Female}

public class Person {
    static int id = 0;
    private String name;
    private Gender gender;
    private Person mother;
    private Person father;
    private Person helpmate;
    int personId = id;

    HashSet<Person> childrens = new HashSet<>();

    Person(String name, Gender g) {
        this.name = name;
        this.gender = g;
        id++;
    }

    void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Gender: " + (this.gender == Gender.Male ? "Male" : "Female"));
        System.out.println("Marital status: " + (this.helpmate != null ? "Married" : "unMarried"));
        if (this.helpmate != null) System.out.println("\tHelpmate: " + this.helpmate.name);
        if (this.childrens.size() == 0) {
            System.out.println("Children: Have no children");
        } else {
            System.out.println("Children:");
            for (Person child :
                    this.childrens) {
                System.out.println("\t" + child.name + " " + (child.gender));
            }
        }
        this.showParents();
        this.yourBrothersAndSisters();
        System.out.println();
    }
    void showParents() {
        String motherName = this.mother != null ? this.mother.name : "Mother unknown";
        String fatherName = this.father != null ? this.father.name : "Father unknown";
        System.out.printf("%s of parents:\n\tMother: %s\n\tFather: %s \n", this.name, motherName, fatherName);
    }

    void married(Person person) {
        this.helpmate = person;
        person.setHelpmate(this);
    }
    void yourBrothersAndSisters() {
        HashSet<Person> childrens = new HashSet<>();
        for (Person parent : Arrays.asList(this.mother, this.father)) {
            if (parent != null) childrens.addAll(parent.childrens);
        }
        if (childrens.size() > 1) {
            System.out.println(this.name + " has brothers and sisters:");
            for (Person child : childrens) {
                if (child == this) continue;
                System.out.println("\t" + child.name + (child.gender == Gender.Male ? " is brother" : " is sister"));
            }
            return;
        }
        System.out.println(this.name + " is single child");
    }

    void addedChild(Person child) {
        this.childrens.add(child);
    }

    void birthChild(String name, Gender g) {
        Person child = new Person(name, g);
        this.addedChild(child);
        if (this.helpmate != null) this.helpmate.addedChild(child);
    }
    void birthChild(Person person) {
        this.addedChild(person);
        if (this.helpmate != null) this.helpmate.addedChild(person);
    }

    void showFamilyTree() {
        Person ancestor = this;
        LinkedList<Person> persons = new LinkedList<>();
        persons.add(this);
        while (persons.size() > 0) {
            Person tmp = persons.pop();
            if (tmp.getMother() != null) persons.add(tmp.getMother());
            if (tmp.getFather() != null) persons.add(tmp.getFather());
            if (tmp.getMother() == null && tmp.getFather() == null && tmp.childrens.size() > 0) {
                ancestor = tmp;
            }
        }
        System.out.println(ancestor.getName() + " + " + (ancestor.helpmate != null ? ancestor.helpmate.getName() : "Unknown"));
        for (Person child:
             ancestor.childrens) {
            System.out.println("|__" + child.getName() + " + " + child.getHelpmate());
        }
    }

    public void setMother(Person mother) {
        this.mother = mother;
        mother.addedChild(this);
    }

    public void setFather(Person father) {
        this.father = father;
        father.addedChild(this);
    }

    public void setHelpmate(Person helpmate) {
        this.helpmate = helpmate;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getHelpmate() {
        return helpmate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

