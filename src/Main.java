import java.util.Scanner;

public class Main {

    static String[] tasks = new String[100];
    static String[] projects = new String[100];
    static String[] changeLog = new String[100];

    static int tasksCount = 0;
    static int projectsCount = 0;
    static int changeLogCount = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix;
        boolean isApplicationRun = true;

        while (isApplicationRun) {
            displayMenu();
            System.out.println("Type number to chose option: ");
            radix = scanner.nextInt();

            switch (radix) {
                case 1 -> {
                    System.out.println("Type your task name: ");
                    String task = scanner.next();
                    addTask(task);
                }
                case 2 -> {
                    System.out.println("Type your task's index to remove: ");
                    int index = scanner.nextInt();
                    removeTask(index);
                }
                case 3 -> {
                    System.out.println("Type your project name: ");
                    String projectName = scanner.next();
                    addProject(projectName);
                }
                case 4 -> {
                    System.out.println("Type your project's index to remove: ");
                    int indexProject = scanner.nextInt();
                    removeProject(indexProject);
                }
                case 5 -> displayTasks();
                case 6 -> displayAllProjects();
                case 7 -> displayAllLogs();
                case 0 -> {
                    isApplicationRun = false;
                    System.out.println("End program.");
                }
                default -> System.out.println("There is no option.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("1 - Create task");
        System.out.println("2 - Remove task");
        System.out.println("3 - Create project");
        System.out.println("4 - Remove project");
        System.out.println("5 - Display all tasks");
        System.out.println("6 - Display all projects");
        System.out.println("7 - Display log");
        System.out.println("0 - Close program");
    }

    public static void addTask(String task) {
        boolean hasCapacityForNewTask = tasksCount < tasks.length;
        if (hasCapacityForNewTask) {
            tasks[tasksCount] = task;
            tasksCount++;
            addLog("Task added: " + task);
        }else {
            addLog("Cannot add task: " + task);
        }
    }

    public static void removeTask(int indexTask) {

        boolean isTaskExist = indexTask < tasksCount;
        if (isTaskExist) {
            for (int i = indexTask; i < tasks.length - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasksCount--;
            addLog("Task " + tasks[indexTask] + " removed.");
        }else {
            addLog("Cannot remove task " + tasks[indexTask]);
        }

    }

    public static void displayTasks() {
        System.out.println("List of tasks: ");
        for (int i = 0; i < tasksCount; i++) {
            System.out.println(tasks[i]);
        }
        addLog("All tasks displayed.");
    }

    public static void addProject(String projectName) {
        boolean hasCapacityForNewProject = projectsCount < projects.length;
        if (hasCapacityForNewProject) {
            projects[projectsCount] = projectName;
            projectsCount++;
            addLog("Project added : " + projectName);
        }else {
            addLog("Cannot add project: " + projectName);
        }
    }

    public static void removeProject(int indexProject) {
        boolean isProjectExist = indexProject < projectsCount;
        if (isProjectExist) {
            for (int i = indexProject; i < tasks.length - 1; i++) {
                projects[i] = projects[i + 1];
            }
            projectsCount--;
            addLog("Removed project: " + projects[indexProject]);
        }else {
            addLog("Cannot remove project " + projects[indexProject]);
        }
    }

    public static void displayAllProjects() {
        System.out.println("All yours projects: ");
        for (int i = 0; i < projectsCount; i++) {
            System.out.println(projects[i]);
        }
        addLog("Displayed all project.");
    }

    public static void addLog(String log) {
        boolean hasCapacityForNewLog = changeLogCount < changeLog.length;
        if (hasCapacityForNewLog) {
            changeLog[changeLogCount] = log;
        }
        changeLogCount++;
    }

    public static void displayAllLogs() {
        System.out.println("ALl logs: ");
        for (int i = 0; i < changeLogCount; i++) {
            System.out.println(changeLog[i]);
        }
    }

}