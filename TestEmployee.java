import java.util.Scanner;
import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
        boolean loggedIn = false;
        System.out.println("Welcome to Employee Management System");
        
        AdminstratorDATA adminData = new AdminstratorDATA(); // import database
        
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Intern> interns = new ArrayList<>();
        ArrayList<Engnieer> engineers = new ArrayList<>(); 

        Scanner scanner = new Scanner(System.in);

        while (true) {
            while (!loggedIn) {
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                
                if (adminData.adminData.containsKey(username) && adminData.adminData.get(username).equals(password)) {
                    System.out.println("Login successful. Welcome, " + username + "!");
                    loggedIn = true;
                } else {
                    System.out.println("Invalid username or password. Exiting the system. Goodbye!");
                    System.exit(0);
                }
            }

            // --- القائمة الرئيسية ---
            System.out.println("\nChoose an option:");
            System.out.println("1. Add manager");
            System.out.println("2. Add intern");
            System.out.println("3. Add engineer");
            System.out.println("4. Show all employees");
            System.out.println("5. Exit Program");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // تنظيف السطر بعد الرقم

            switch (choice) {
                case 1:
                    while(true){
                        System.out.println("Enter details for Manager #" + (managers.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); 
                        managers.add(new Manager(managers.size()+1, name, jobTitle, salary, 0));
                        // استفسار المستخدم إذا كان يريد إضافة مدير آخر
                        System.out.print("Do you want to add another manager? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equals("yes")) 
                            continue;
                        else if (response.equals("no")){
                            System.out.println("Managers added successfully.");
                            break;
                        }
                            
                        else{
                            System.out.println("Invalid response. Exiting manager addition.");
                            break;
                        }
                    }break ;
                    
                case 2: 
                    System.out.println("How many interns do you want to add?");
                    int numInterns = scanner.nextInt();
                    scanner.nextLine(); 

                    for (int i = 0; i < numInterns; i++) {
                        System.out.println("Enter details for Intern #" + (interns.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        
                        
                        interns.add(new Intern(i+1, name, jobTitle));
                    }
                    System.out.println("Interns added successfully.");
                    break;

                case 3: 
                    System.out.println("How many engineers do you want to add?");
                    int numEngineers = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numEngineers; i++) {
                        System.out.println("Enter details for Engineer #" + (engineers.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();

                        
                        engineers.add(new Engnieer(i+1, name, jobTitle, salary, 8));
                    }
                    System.out.println("Engineers added successfully.");
                    break;

                case 4: 
                    System.out.println("\n--- Displaying all employees ---");
                    
                    System.out.println("Managers:");
                    if (managers.isEmpty()) {
                        System.out.println("No managers available.");
                    } else {
                        for (Manager m : managers) {
                            System.out.println(m.getDetails());
                        }
                    }

                    System.out.println("\nInterns:");
                    if (interns.isEmpty()) {
                        System.out.println("No interns available.");
                    } else {
                        for (Intern in : interns) {
                            System.out.println(in.getDetails());
                        }
                    }

                    System.out.println("\nEngineers:");
                    if (engineers.isEmpty()) {
                        System.out.println("No engineers available.");
                    } else {
                        for (Engnieer en : engineers) {
                            System.out.println(en.getDetails());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Logging out. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}