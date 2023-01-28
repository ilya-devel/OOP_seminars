package sem5.Homeworks.PhoneBook.Person;

import java.io.Serializable;
import java.util.HashMap;

public class Person implements IPerson, Serializable {
    public static int id = 0;
    private int idPerson;
    private String name;
    private HashMap<String, String> phoneList;

    public Person(String name) {
        this.idPerson = id++;
        this.name = name;
        this.phoneList = new HashMap<>();
    }

    @Override
    public void addNewPhone(String name, String phone) {
        this.phoneList.put(name, phone);
    }

    @Override
    public void removePhone(String name) {
        this.phoneList.remove(name);
    }

    @Override
    public void editPhone(String name, String phone) {
        this.phoneList.replace(name, phone);
    }

    public String getName() {
        return name;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public HashMap<String, String> getPhoneList() {
        return phoneList;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (var phone : this.getPhoneList().keySet()) {
            msg.append(this.getName()).append(";").append(phone).append(";").append(getPhoneList().get(phone)).append("\n");
        }
        return msg.toString();
    }

    public static void setId(int id) {
        Person.id = id;
    }
}
