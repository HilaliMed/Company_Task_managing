import model.Task;
import service.Task_service;

void main() {
    ArrayList<Task> task_list = new ArrayList<>();
    String Command;
    IO.println("Welcome to task list management. \nThese are the set of commands to type while the program is running");
    IO.println("Add: add a new task with a deadline    " + "     Remove: remove an existing task\n");
    IO.println("Check: searching the name of a task" + "      Display: display the saved tasks\n");
    IO.println("Modify: modify the name or the state of a task     " + "Quit: end the program    ");
    Scanner sc = new Scanner(System.in);
    String quitter = "quitting";
    while (!quitter.equals("q")) {
        IO.print("Enter a command: ");
        String choice = sc.nextLine().trim();
        Command = choice.toLowerCase();

        switch (Command) {
            case "add":
                IO.print("Enter the title of the task: ");
                String value1 = sc.nextLine();
                IO.print("Enter the duration to deadline");
                int value2 = sc.nextInt();
                Task entry = new Task(value1, value2);
                Task_service.Add(task_list, entry);
                IO.println("Task registered successfully.");


                break;

            case "remove":
                if (task_list.isEmpty()) {
                    IO.println("Error: Empty list.");
                } else {
                    IO.print("Enter the name to remove with the correct cases: ");
                    String nameToRemove = sc.nextLine().trim();


                    if (Task_service.checking(task_list, nameToRemove)) {
                        Task_service.Removal(task_list, nameToRemove);
                        IO.println("Name \"" + nameToRemove + "\" removed successfully.");
                    } else {
                        IO.println("Name \"" + nameToRemove + "\" not found in the list.");
                    }
                }


                break;

            case "display":
                for (Task T : task_list) {
                    T.display_Task();
                }


                break;

            case "check":
                IO.print("Input the task title: ");
                String Check = sc.nextLine();

                boolean found = Task_service.checking(task_list, Check);
                if (found) {
                    IO.println("Task present.");
                } else {
                    IO.println("Unavailable name or invalid input");
                }


                break;

            case "modify":

                if (task_list.isEmpty()) {
                    IO.println("Error: Empty list.");
                } else {
                    IO.print("Enter the name of the task to modify: ");
                    String task_to_modify = sc.nextLine().trim();

                    boolean verify = Task_service.checking(task_list, task_to_modify);
                    if (verify) {
                        IO.print("What do you want to change( n: task name, d: days to deadline, s: mark the task as finished): ");
                        String mod_option = sc.nextLine().trim();
                        switch (mod_option) {
                            case "n":
                                IO.print("Enter new name: ");
                                String new_name = sc.nextLine();
                                Task_service.modifyName(task_list, task_to_modify, new_name);
                                break;

                            case "d":
                                IO.print("Enter new time in days to deadline:");
                                int new_time = sc.nextInt();
                                Task_service.Modify_date(task_list, task_to_modify, new_time);
                                break;

                            case "s":
                                Task_service.change_state(task_list, task_to_modify);

                        }
                    } else {
                        IO.println("Unavailable name or invalid input");
                    }

                }


                break;
            case "quit":
                IO.println("Program ending.");
                quitter = "q";

                break;

            default:
                IO.println("Invalid input.");
        }
    }
    sc.close();
    IO.println("Thank you for using this program.");


}