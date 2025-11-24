import java.util.Scanner;

public class TestEmployee{
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        AdminstratorDATA adminData = new AdminstratorDATA();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (true) {
            System.out.print("Please enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();
            if (adminData.adminData.containsKey(username) && adminData.adminData.get(username).equals(password)) {
                System.out.println("Login successful. Welcome, " + username + "!");
                break;
            } else {
                System.out.println("Invalid username or password. Exiting the system. Goodbye!");
                System.exit(0);
            }
            System.out.println("choose an option:\n1. Add manager\n2. Add intern\n3. Add engineer");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How many managers do you want to add?");
                    int numManagers = scanner.nextInt();
                    Employee[] managers = new Manager[numManagers];
                    for (int i = 0; i < managers.length; i++) {
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter manager ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter manager name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter manager job title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter manager salary: ");
                        double salary = scanner.nextDouble();
                        managers[i] = new Manager(id, name, jobTitle, salary, 0);
                    }                    System.out.println("Managers added successfully.");
                    break;
                case 2:
                    System.out.println("how many interns do you want to add?");
                    int numInterns = scanner.nextInt();
                    Employee[] interns = new Intern[numInterns];
                    for (int i = 0; i < interns.length; i++) {
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter intern ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter intern name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter intern job title: ");
                        String jobTitle = scanner.nextLine();
                        interns[i] = new Intern(id, name, jobTitle);
                    }                    System.out.println("Interns added successfully.");
                    break;
                case 3:
                    System.out.println("how many engineers do you want to add?");
                    int numEngineers = scanner.nextInt();
                    Employee[] engineers = new Engnieer[numEngineers];
                    for (int i = 0; i < engineers.length; i++) {
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter engineer ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter engineer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter engineer job title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter engineer salary: ");
                        double salary = scanner.nextDouble();
                        engineers[i] = new Engnieer(id, name, jobTitle, salary,8);
                    }                    System.out.println("Engineers added successfully.");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            
        }
        
            scanner.close();
        }        
    }
}