package sem4.Homeworks;

import sem4.Homeworks.Model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Control implements IControl {

    @Override
    public void saveDb(LinkedList<Task> listTasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            oos.writeObject(listTasks);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Database saved");
    }

    @Override
    public LinkedList<Task> loadDb() {
        LinkedList<Task> tasks;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            tasks = (LinkedList<Task>)ois.readObject();
            int maxID = 0;
            for (Task task : tasks) {
                if (task.getIdTask() > maxID) maxID = task.getIdTask();
            }
            Task.setId(++maxID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            tasks = new LinkedList<>();
        }
        return tasks;
    }

    @Override
    public int showMenu() {
        System.out.println("Select an action:");
        System.out.println("\t1. Add task");
        System.out.println("\t2. Show uncompleted tasks");
        System.out.println("\t3. Edit tasks");
        System.out.println("\t4. Show task");
        System.out.println("\t5. Import tasks");
        System.out.println("\t6. Export tasks");
        System.out.println("\t0. Close application");

        Scanner in = new Scanner(System.in);
        int choice;
        try {
            choice = in.nextInt();
        } catch (Exception e) {
            choice = this.showMenu();
        }
        return choice;
    }

    @Override
    public void showTasks(LinkedList<Task> listTasks) {
        System.out.println();
        if (listTasks.size() > 0) {
            System.out.println("Current tasks:");
            System.out.printf("|%-20s|%-12s|%-12s|%-7s|%-20s|\n", "RunDate", "Priority", "Status", "TaskID", "Title");
            Comparator<Task> tskComp = new TaskDateComparator().thenComparing(new TaskPriorityComparator()).
                    thenComparing(new TaskIdComparator());
            listTasks.sort(tskComp);
            for (Task tsk : listTasks) {
                if (tsk.getStatus() != Status.COMPLETE) {
                    String date;
                    if (tsk.getRunDate() != null) {
                        date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(tsk.getRunDate());
                    } else {
                        date = "null";
                    }
                    System.out.printf("|%-20s|%-12s|%-12s|%-7s|%-20s|\n",
                            date,
                            tsk.getPriority(), tsk.getStatus(), tsk.getIdTask(), tsk.getTitle());
                }
            }
        } else {
            System.out.println("List of tasks is empty");
        }
    }

    @Override
    public Task addTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter title of task:");
        return new Task(in.nextLine());
    }

    @Override
    public void editTask(LinkedList<Task> listTasks) {
        Scanner in = new Scanner(System.in);
        int taskId;
        System.out.print("Enter task ID for edit > ");
        try {
            taskId = in.nextInt();
            for (int i = 0; i < listTasks.size(); i++) {
                if (listTasks.get(i).getIdTask() == taskId) {
                    Task tsk = listTasks.get(i);
                    int choice = choiceEdit();
                    switch (choice) {
                        case 1 -> setData(tsk);
                        case 2 -> setPriority(tsk);
                        case 3 -> setStatus(tsk);
                        case 4 -> setTitle(tsk);
                        case 5 -> setDescription(tsk);
                        case 0 -> System.out.println("\tYes");
                        default -> editTask(listTasks);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Editing completed");
    }

    @Override
    public void removeTask() {

    }

    @Override
    public void run() {
        LinkedList<Task> listTasks = this.loadDb();
        boolean statusApp = true;
        while (statusApp) {
            int choice = showMenu();
            switch (choice) {
                case 1 -> listTasks.add(this.addTask());
                case 2 -> this.showTasks(listTasks);
                case 3 -> editTask(listTasks);
                case 4 -> showTask(listTasks);
                case 5 -> importTasksCSV(listTasks);
                case 6 -> exportTasksCSV(listTasks);
                case 0 -> {
                    statusApp = false;
                    this.saveDb(listTasks);
                }
            }
        }
    }

    @Override
    public void importTasksCSV(LinkedList<Task> listTasks) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of("exportData.csv"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 1; i < lines.size(); i++) {
            List<String> row = List.of(lines.get(i).split(";"));
            Task tskTemp = new Task(row.get(4));
            tskTemp.setDescription(row.get(5));
            switch (row.get(1)) {
                case "IMMEDIATELY" -> tskTemp.setPriority(Priority.IMMEDIATELY);
                case "HIGHTY" -> tskTemp.setPriority(Priority.HIGHTY);
                case "MEDIUM" -> tskTemp.setPriority(Priority.MEDIUM);
                case "LOW" -> tskTemp.setPriority(Priority.LOW);
                case "NONE" -> tskTemp.setPriority(Priority.NONE);
                default -> tskTemp.setPriority(Priority.NONE);
            }
            switch (row.get(2)) {
                case "COMPLETE" -> tskTemp.setStatus(Status.COMPLETE);
                case "IN_PROCESS" -> tskTemp.setStatus(Status.IN_PROCESS);
                case "WAITING" -> tskTemp.setStatus(Status.WAITING);
                case "NONE" -> tskTemp.setStatus(Status.NONE);
                default -> tskTemp.setStatus(Status.NONE);
            }
            if (!row.get(0).equals("null")) tskTemp.setRunDate(LocalDateTime.parse(row.get(0)));
            listTasks.add(tskTemp);
        }
    }

    @Override
    public void exportTasksCSV(LinkedList<Task> listTasks) {
        try (FileWriter writer = new FileWriter("exportData.csv", false)){
            String headers = "RunDate;Priority;Status;TaskID;Title;Description\n";
            writer.write(headers);
            for (Task tsk : listTasks) {
                writer.write(tsk.toString());
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int choiceEdit() {
        System.out.println();
        System.out.println("Select an action for editing:");
        System.out.println("\t1. Set run date");
        System.out.println("\t2. Set priority");
        System.out.println("\t3. Set status");
        System.out.println("\t4. Set title");
        System.out.println("\t5. Set description");
        System.out.println("\t0. Back");
        System.out.print(" >> ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    @Override
    public void setData(Task tsk) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter year for task");
        int year = in.nextInt();
        System.out.println("Enter month for task");
        int month = in.nextInt();
        System.out.println("Enter day for task");
        int day = in.nextInt();
        System.out.println("Enter hour for task");
        int hour = in.nextInt();
        System.out.println("Enter minutes for task");
        int minutes = in.nextInt();
        tsk.setRunDate(year, month, day, hour, minutes);
    }

    @Override
    public void setPriority(Task tsk) {
        Scanner in = new Scanner(System.in);
        System.out.println("Select priority^");
        System.out.println("\t1. IMMEDIATELY");
        System.out.println("\t2. HIGHTY");
        System.out.println("\t3. MEDIUM");
        System.out.println("\t4. LOW");
        System.out.println("\t5. NONE");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> tsk.setPriority(Priority.IMMEDIATELY);
            case 2 -> tsk.setPriority(Priority.HIGHTY);
            case 3 -> tsk.setPriority(Priority.MEDIUM);
            case 4 -> tsk.setPriority(Priority.LOW);
            case 5 -> tsk.setPriority(Priority.NONE);
            case 0 -> tsk.setPriority(tsk.getPriority());
            default -> setPriority(tsk);
        }
        System.out.println("Complete");
    }

    @Override
    public void setStatus(Task tsk) {
        Scanner in = new Scanner(System.in);
        System.out.println("Select priority^");
        System.out.println("\t1. COMPLETE");
        System.out.println("\t2. IN_PROCESS");
        System.out.println("\t3. WAITING");
        System.out.println("\t4. NONE");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> tsk.setStatus(Status.COMPLETE);
            case 2 -> tsk.setStatus(Status.IN_PROCESS);
            case 3 -> tsk.setStatus(Status.WAITING);
            case 4 -> tsk.setStatus(Status.NONE);
            case 0 -> tsk.setStatus(tsk.getStatus());
            default -> setStatus(tsk);
        }
        System.out.println("Complete");
    }

    @Override
    public void setTitle(Task tsk) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new title:");
        tsk.setTitle(in.nextLine());
        System.out.println("Complete");
    }

    @Override
    public void setDescription(Task tsk) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new Description:");
        tsk.setDescription(in.nextLine());
        System.out.println("Complete");
    }

    @Override
    public void showTask(LinkedList<Task> listTasks) {
        Scanner in = new Scanner(System.in);
        int taskId;
        System.out.print("Enter task ID for show > ");
        try {
            taskId = in.nextInt();
            for (Task listTask : listTasks) {
                if (listTask.getIdTask() == taskId) listTask.showInfoAboutTask();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
}
