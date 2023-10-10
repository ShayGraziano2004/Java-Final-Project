public class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructors
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }
}
