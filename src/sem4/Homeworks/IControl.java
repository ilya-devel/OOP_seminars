package sem4.Homeworks;

import sem4.Homeworks.Model.Task;

import java.util.LinkedList;

public interface IControl {
    void saveDb(LinkedList<Task> listTasks);
    LinkedList<Task> loadDb();
    int showMenu();
    void showTasks(LinkedList<Task> listTasks);
    Task addTask();
    void editTask(LinkedList<Task> listTasks);
    void removeTask();
    void run();
    void importTasksCSV(LinkedList<Task> listTasks);
    void exportTasksCSV(LinkedList<Task> listTasks);
    int choiceEdit();
    void setData(Task tsk);
    void setPriority(Task tsk);
    void setStatus(Task tsk);
    void setTitle(Task tsk);
    void setDescription(Task tsk);
    void showTask(LinkedList<Task> listTasks);
}
