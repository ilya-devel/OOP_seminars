package sem2.homeworks.FamilyTree;

import java.util.Arrays;
import java.util.HashSet;

public class Person extends Character{


    public Person(String name, Gender gender) {
        this.id_person = id++;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public void showInfo() {
        System.out.println("About this person:");
        System.out.println("\tName: " + this.name);
        System.out.println("\tGender: " + this.gender);
        System.out.println("\tFather: " + (this.getFather() != null ? this.getFather().name : "Unknown"));
        System.out.println("\tMother: " + (this.getMother() != null ? this.getMother().name : "Unknown"));
        System.out.println("\tMarried: " + (this.getHelpmate() != null ? this.getHelpmate().name : "Unmarried"));
        if (this.getChildren().size() <= 1) {
            System.out.println("\tChildren: NO");
        } else {
            System.out.println("\tChildren:");
            for (Character child: this.getChildren()) {
                if (child == this) continue;
                System.out.println("\t\t" + child.name + (child.gender == Gender.Male ? " - son" : " - daughter"));
            }
        }
        this.showBrothersAndSisters();
    }

    @Override
    public void married(Character helpmate) {
        System.out.println("I married " + helpmate.name);
        this.setHelpmate(helpmate);
    }

    @Override
    public void birthChild(String name, Gender gender) {
        System.out.println("You have a " + (gender == Gender.Male ? "son" : "daughter"));
        Person child = new Person(name, gender);
        if (this.gender == Gender.Male) {
            child.setFather(this);
            child.setMother(this.getHelpmate());
        } else {
            child.setFather(this.getHelpmate());
            child.setMother(this);
        }
        this.children.add(child);
    }

    @Override
    public void showBrothersAndSisters() {
        HashSet<Person> children = new HashSet<>();
        for (Character parent : Arrays.asList(this.getFather(), this.getMother())) {
            if (parent == null) continue;
            children.addAll(parent.getChildren());
        }
        if (children.size() <= 1) {
            System.out.println("You dont't have brothers and sisters");
        } else {
            System.out.println("Brothers and sisters:");
            for (Person child : children) {
                if (child == this) continue;
                System.out.println("\t" + child.name + (child.gender == Gender.Male ? " - brother" : " - sister"));
            }
        }
    }

    @Override
    public void findParent(Character parent) {
        if (parent.gender == Gender.Male) {
            System.out.println("I found my father this is " + parent.name);
            this.setFather(parent);
        }
        if (parent.gender == Gender.Female) {
            System.out.println("I found my mother this is " + parent.name);
            this.setMother(parent);
        }
    }
}
