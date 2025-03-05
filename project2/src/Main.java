//Jocelin Martinez-Reyes 2/18/25 Project 2

import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Tasks> taskList = new ArrayList<>();

    public static void main(String[] args) {
        options();
        try {
            int quit = 0;
            while (quit == 0) {
                int userResponse = input.nextInt();
                input.nextLine();
                if (userResponse == 1) {
                    addTask();
                } else if (userResponse == 2) {
                    deleteTask();
                } else if (userResponse == 3) {
                    updateTask();
                } else if (userResponse == 4) {
                    listTasks();
                } else if (userResponse == 5) {
                    taskItem();
                } else if (userResponse == 0) {
                    quit = 1;
                    System.out.println("BYE-BYE\nBYE-BYE\nBYE-BYE");
                } else {
                    options();
                    System.out.println("Try again bud, that wasn't a choice.\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }


    static void options() {
        System.out.println("""
                Please choose an option:
                (1) Add a task.
                (2) Remove a task.
                (3) Update a task.
                (4) List all tasks.
                (5) List # Priority Tasks
                (0) Exit.
                """);
    }

    static void addTask() {
        System.out.println("What's the name of the task?");
        String title = input.nextLine();
        System.out.println("Description of the your task.");
        String desc = input.nextLine();
        System.out.println("What Priority is it?(0 [lowest] - 5 [highest])");
        int prio = input.nextInt();
        taskList.add(new Tasks(title, desc, prio));
        options();
    }

    static void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.\n(Hint: Add a task:>!)");
        } else {
            System.out.println("List of all of your tasks:\n");
            for (Tasks task : taskList) {
                System.out.println(task);
            }
        }
        options();
    }

    static void taskItem() {
        System.out.println("What priority of tasks do you wish to see?");
        int prio = input.nextInt();
        input.nextLine();

        if (prio >= 0 && prio <= 5) {
            for (Tasks task : taskList) {
                if (task.getPrio() == prio) {
                    System.out.println(task);
                }
            }

            options();
        }
    }

    static void deleteTask() {
        System.out.println("Enter the task number to delete:\n");
        listTasks();
        int taskNumber = input.nextInt();
        input.nextLine();

        if (taskNumber > 0 && taskNumber <= taskList.size()) {
            taskList.remove(taskNumber - 1);
            System.out.println("Task removed successfully.\n");
        } else {
            System.out.println("Invalid task number.\n");
        }
        options();
    }


    static void updateTask() {
        System.out.println("Which one: ");
        listTasks();
        int taskNumber = input.nextInt();
        input.nextLine();

        if (taskNumber > 0 && taskNumber <= taskList.size()) {
            Tasks task = taskList.get(taskNumber - 1);

            System.out.println("Enter the new title of the task:");
            String newTitle = input.nextLine();
            task.setTitle(newTitle);

            System.out.println("Enter the new description of the task:");
            String newDesc = input.nextLine();
            task.setDesc(newDesc);

            System.out.println("Enter the new priority (0 [lowest] - 5 [highest]):");
            int newPrio = input.nextInt();
            task.setPrio(newPrio);

        } else {
            System.out.println("Invalid task number.\n");
        }
        options();
    }
}
