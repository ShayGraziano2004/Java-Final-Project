import java.util.ArrayList;
import java.util.List;

public class ToDoListApp {
    private List<Task> tasks;

    public ToDoListApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(Task task) {
        if (tasks.contains(task)) {
            task.markAsCompleted();
        }
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void clearCompletedTasks() {
        tasks.removeIf(Task::isCompleted);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
