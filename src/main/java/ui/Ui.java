package ui;

import java.util.Scanner;

import tasks.Task;
import tasks.TaskList;

/**
 * The {@code Ui} class handles interactions with the user, including displaying messages,
 * showing the list of tasks, and reading user input. It acts as the user interface for
 * the application.
 */
public class Ui {

    private static final String DIVIDER = "________________________________________\n";
    private final Scanner scanner;

    /**
     * Constructs a new {@code Ui} object and initializes the scanner for user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message to the user.
     */
    public void showWelcome() {
        System.out.println(DIVIDER + "Hello! I'm Downy.\nHow can I help?\n" + DIVIDER);
    }

    /**
     * Displays a line divider to the user.
     */
    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays an exit message to the user and closes the scanner.
     */
    public void showExitMessage() {
        this.scanner.close();
        System.out.println(DIVIDER + "Bye! Yippee!");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public static void showErrorMessage(String message) {
        System.out.println(DIVIDER + "Error: " + message + "\n" + DIVIDER);
    }

    /**
     * Displays a generic message to the user.
     *
     * @param message The message to be displayed.
     */
    public static void showMessage(String message) {
        System.out.println(DIVIDER + message + "\n" + DIVIDER);
    }

    /**
     * Displays the list of tasks to the user.
     *
     * @param tasks The task list containing the tasks to be displayed.
     */
    public void displayTasks(TaskList tasks) {
        System.out.print(DIVIDER);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println((i + 1) + ". " + tasks.getTask(i));
        }
        System.out.print(DIVIDER);
    }

    /**
     * Displays tasks from the task list that contain the specified keyword in their names.
     * The search is case-insensitive, and only matching tasks are displayed. If no tasks
     * match the keyword, a message indicating that no matching tasks were found is shown.
     *
     * @param tasks   The {@code TaskList} containing the tasks to be searched.
     * @param keyword The keyword to search for within the task names.
     */
    public void displayMatchingTasks(TaskList tasks, String keyword) {
        System.out.printf(DIVIDER);
        System.out.println("Here are the tasks in your list that match the keyword:");
        String lowerCaseKeyword = keyword.toLowerCase();
        int matchCount = 0;
        for (int i = 0; i < tasks.getSize(); i++) {
            String taskName = tasks.getTask(i).getName().toLowerCase();

            if (taskName.contains(lowerCaseKeyword)) {
                System.out.println((matchCount + 1) + ". " + tasks.getTask(i));
                matchCount++;
            }
        }
        if (matchCount == 0) {
            System.out.println("No matching tasks found.");
        }

        System.out.printf(DIVIDER);
    }

    /**
     * Displays a message indicating that a task is complete.
     *
     * @param t The task that is complete.
     */
    public void displayCompletedTask(Task t) {
        System.out.println(DIVIDER + "Nice! You've completed this task:\n  " + t + "\n" + DIVIDER);
    }

    /**
     * Displays a message indicating that a task is not complete.
     *
     * @param t The task that is not complete.
     */
    public void displayIncompleteTask(Task t) {
        System.out.println(DIVIDER + "Ok! This task is not complete:\n  " + t + "\n" + DIVIDER);
    }

    /**
     * Displays a message indicating that a task has been deleted.
     *
     * @param t The task that has been deleted.
     */
    public void displayDeletedTask(Task t) {
        System.out.println(DIVIDER + "Ok! This task has been removed:\n  " + t + "\n" + DIVIDER);
    }

    /**
     * Displays a message indicating that a task has been added and shows the current
     * number of tasks in the list.
     *
     * @param t         The task that has been added.
     * @param taskCount The current number of tasks in the list.
     */
    public void displayTaskAdded(Task t, int taskCount) {
        System.out.println(DIVIDER + "Okay! Added this task:\n  " + t
                + "\nNow you have " + taskCount + " tasks in this list\n" + DIVIDER);
    }

    /**
     * Reads and returns the next command input by the user.
     *
     * @return The command input by the user.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Displays a help message listing all valid commands.
     */
    public void displayHelp() {
        System.out.print(DIVIDER);
        System.out.println("Here are a list of valid commands:");
        System.out.println(" - list");
        System.out.println(" - mark <taskNumber>");
        System.out.println(" - unmark <taskNumber>");
        System.out.println(" - delete <taskNumber>");
        System.out.println(" - todo <taskDescription>");
        System.out.println(" - deadline <taskDescription> /by <dueDate>");
        System.out.println(" - event <taskDescription> /from <startTime> /to <endTime>");
        System.out.println(" - bye");
        System.out.println(" - help");
        System.out.println(DIVIDER);
    }
}
