package sem5.Homeworks.PhoneBook.Control;

import sem5.Homeworks.PhoneBook.Person.Person;
import sem5.Homeworks.PhoneBook.View.View;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MainControl implements IMainControl, IExportImport, Serializable {
    static HashSet<Person> listPersons = new HashSet<>();
    static String FILENAME = "PhoneDB.dat";
    static private boolean status = true;
    private static View view = new View();

    @Override
    public void exportDb() {
        try (FileWriter writer = new FileWriter("ExportPhoneDB.csv", false)){
            String headers = "Name;Comment;Phone\n";
            writer.write(headers);
            for (Person p : listPersons) {
                writer.write(p.toString());
            }
            System.out.println("Export complete\n");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Export error");
        }

    }

    @Override
    public void importDb() {
        List<String> rows = new ArrayList<>();
        try {
            rows = Files.readAllLines(Path.of("ExportPhoneDB.csv"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Person tmp = null;
        List<String> ltmp;
        for (int i = 1; i < rows.size(); i++) {
            ltmp = Arrays.asList(rows.get(i).split(";"));
            if (tmp != null && tmp.getName().equals(ltmp.get(0))){
                tmp.addNewPhone(ltmp.get(1), ltmp.get(2));
            } else {
                if (tmp != null) listPersons.add(tmp);
                tmp = new Person(ltmp.get(0));
                tmp.addNewPhone(ltmp.get(1), ltmp.get(2));
            }
        }
        listPersons.add(tmp);
        System.out.println("Import complete");
    }

    @Override
    public void runApplication() {
        this.loadDb();
        System.out.println("Running application \"PhoneBook\"");
        while (status) {
            int mainChoice = view.showMenu();
            switch (mainChoice) {
                case 1 -> view.showContacts(listPersons);
                case 2 -> {
                    int idContact = view.choiceContacts(listPersons);
                    Person p = null;
                    for (Person per : listPersons) if (per.getIdPerson() == idContact) p = per;
                    view.showPhoneList(p);
                }
                case 3 -> this.addContact();
                case 4 -> {
                    int idContact = view.choiceContacts(listPersons);
                    Person p = null;
                    for (Person per : listPersons) if (per.getIdPerson() == idContact) p = per;
                    if (p != null) {
                        String phone = view.getPhone();
                        String comm = view.getComment();
                        p.addNewPhone(comm, phone);
                        System.out.println("Phone added\n");
                    } else {
                        System.out.println("Unvalid id");
                    }
                }
                case 5 -> this.exportDb();
                case 6 -> this.importDb();
                case 0 -> status = false;
            }
            if (!status) {
                this.saveDb();
                break;
            }
        }
    }

    @Override
    public void loadDb() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            listPersons = (HashSet<Person>) ois.readObject();
            int maxID = 0;
            for (Person p : listPersons) {
                if (p.getIdPerson() > maxID) maxID = p.getIdPerson();
            }
            Person.setId(++maxID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listPersons = new HashSet<>();
        }
        System.out.println("Base loading\n");
    }

    @Override
    public void saveDb() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(listPersons);
            System.out.println("Database saved");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());
            System.out.println("Saving ERROR");
        }

    }

    @Override
    public void addContact() {
        String name = view.getName();
        listPersons.add(new Person(name));
    }
}
