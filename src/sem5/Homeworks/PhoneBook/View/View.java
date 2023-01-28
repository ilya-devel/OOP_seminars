package sem5.Homeworks.PhoneBook.View;

import sem5.Homeworks.PhoneBook.Person.Person;

import java.util.HashSet;
import java.util.Scanner;

public class View implements IView {


    @Override
    public void showContacts(HashSet<Person> listPersons) {
        if (listPersons.size() > 0) {
            System.out.println("\nList contacts:");
            System.out.printf("|%-8s|%-15s|\n", "PersonID", "Name");
            System.out.println("|========|===============|");
            for (Person p : listPersons) {
                System.out.printf("|%-8d|%-15s|\n", p.getIdPerson(), p.getName());
                System.out.println("|--------|---------------|");
            }
        } else {
            System.out.println("LIST EMPTY");
        }
    }

    public int choiceContacts(HashSet<Person> listPersons) {
        Scanner in = new Scanner(System.in);
        this.showContacts(listPersons);
        return in.nextInt();
    }

    @Override
    public void showPhoneList(Person p) {
        if (p != null && p.getPhoneList().size() > 0) {
            System.out.printf("|%-15s|%-15s|%-15s|\n", "Person", "Phone", "Comment");
            System.out.println("|===============|===============|===============|");
            for (var phone : p.getPhoneList().keySet()) {
                System.out.printf("|%-15s|%-15s|%-15s|\n", p.getName(), p.getPhoneList().get(phone), phone);
                System.out.println("|---------------|---------------|---------------|");
            }
        } else {
            System.out.println("LIST EMPTY OR NOT CONTACT");
        }
    }

    @Override
    public int showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Main menu, choice operation:");
        System.out.println("\t1. Show contacts");
        System.out.println("\t2. Show phones of contact");
        System.out.println("\t3. Add contact");
        System.out.println("\t4. Add phone for contact");
        System.out.println("\t5. Export base");
        System.out.println("\t6. Import base");
        System.out.println("\t0. Close application");
        return in.nextInt();
    }

    @Override
    public String getName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name contact > ");
        return in.nextLine();
    }

    @Override
    public int getIndex() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter index of Person > ");
        return in.nextInt();
    }

    @Override
    public String getPhone() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new phone > ");
        return in.nextLine();
    }

    @Override
    public String getComment() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter comment for phone > ");
        return in.nextLine();
    }

    @Override
    public int choiceOperation() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter index of Person > ");
        return in.nextInt();
    }
}
