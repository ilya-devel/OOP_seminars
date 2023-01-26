package sem4.Homeworks.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Task implements Serializable {
    private static int id = 0;
    private final int idTask;
    private final LocalDateTime createDate;
    private LocalDateTime runDate;
    private String title;
    private Priority priority;
    private String description;
    private Status status;

    public Task(String title) {
        this.createDate = LocalDateTime.now();
        this.title = title;
        this.idTask = id++;
        this.priority = Priority.NONE;
        this.status = Status.NONE;
    }

    public void showInfoAboutTask() {
        System.out.println("Task ID: " + this.idTask);
        System.out.println("Task create: " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(this.createDate));
        System.out.println("Task run: " + (this.runDate != null ? DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format((TemporalAccessor) this.runDate) : "no date"));
//        System.out.println("Task run: " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format((TemporalAccessor) this.runDate));
        System.out.println("Task title: " + this.title);
        System.out.println("Task description: " + this.description);
        System.out.println("Task priority: " + this.priority);
        System.out.println("Task status: " + this.status);
        System.out.println();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRunDate(LocalDateTime runDate) {
        this.runDate = runDate;
    }
    public <T extends Number> void setRunDate(T year, T month, T day, T hour, T minute) {
        this.runDate = LocalDateTime.of(year.intValue(), month.intValue(), day.intValue(), hour.intValue(), minute.intValue(), 0);
    }
    public int getIdTask() {
        return idTask;
    }

    public LocalDateTime getRunDate() {
        return runDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public static void setId(int id) {
        Task.id = id;
    }
    public String toString() {
        return (
                (this.runDate != null ? this.runDate.toString() : "null") + ";"
                + this.priority + ";" + this.status + ";" + this.idTask + ";"
                + this.title + ";" + this.description + "\n"
                );
    }
}
