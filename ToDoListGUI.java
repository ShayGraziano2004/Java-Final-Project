import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ToDoListGUI extends Application {

    private ListView<Task> taskListView;
    private TextField titleField;
    private TextArea descriptionField;
    private Button addButton;
    private Button markCompletedButton;
    private Button deleteButton;
    private Button clearCompletedButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the GUI components
        taskListView = new ListView<>();
        titleField = new TextField();
        descriptionField = new TextArea();
        addButton = new Button("Add");
        markCompletedButton = new Button("Mark Completed");
        deleteButton = new Button("Delete");
        clearCompletedButton = new Button("Clear Completed");

        // Create the layout for the main window
        BorderPane root = new BorderPane();

        // Top section for task input
        VBox inputBox = new VBox();
        inputBox.setSpacing(5);
        inputBox.getChildren().addAll(
                new Label("Title:"),
                titleField,
                new Label("Description:"),
                descriptionField,
                addButton
        );

        // Left section for task list
        VBox listBox = new VBox();
        listBox.getChildren().add(taskListView);

        // Right section for task actions
        VBox actionBox = new VBox();
        actionBox.setSpacing(5);
        actionBox.getChildren().addAll(
                markCompletedButton,
                deleteButton,
                clearCompletedButton
        );

        root.setLeft(listBox);
        root.setCenter(inputBox);
        root.setRight(actionBox);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handling
        addButton.setOnAction(e -> addTask());
        markCompletedButton.setOnAction(e -> markCompletedTasks());
        deleteButton.setOnAction(e -> deleteSelectedTasks());
        clearCompletedButton.setOnAction(e -> clearCompletedTasks());
    }

    private void addTask() {
        String title = titleField.getText();
        String description = descriptionField.getText();

        if (!title.isEmpty()) {
            Task newTask = new Task(title, description);
            taskListView.getItems().add(newTask);
            titleField.clear();
            descriptionField.clear();
        }
    }

    private void markCompletedTasks() {
        taskListView.getItems().forEach(task -> {
            if (taskListView.getSelectionModel().isSelected(taskListView.getItems().indexOf(task))) {
                task.markAsCompleted();
            }
        });
    }

    private void deleteSelectedTasks() {
        taskListView.getItems().removeAll(
                taskListView.getSelectionModel().getSelectedItems()
        );
    }

    private void clearCompletedTasks() {
        taskListView.getItems().removeIf(Task::isCompleted);
    }

    public static class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markAsCompleted() {
            completed = true;
        }

        @Override
        public String toString() {
            return getTitle();
        }
    }
}
