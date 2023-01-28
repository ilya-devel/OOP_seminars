package sem5.Homeworks.PhoneBook.Person;

public interface IPerson {
    void addNewPhone(String name, String phone);
    void removePhone(String name);
    void editPhone(String name, String phone);
}
