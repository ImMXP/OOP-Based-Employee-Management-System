import java.util.Scanner;
import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
        boolean loggedIn = true;
        System.out.println("Welcome to Employee Management System");
        
        AdminstratorDATA adminData = new AdminstratorDATA(); 
        
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Intern> interns = new ArrayList<>();
        ArrayList<Engnieer> engineers = new ArrayList<>(); 

        Scanner scanner = new Scanner(System.in);

        while (true) {
            while (loggedIn) {
                for(int i=2;i>=0;i--){
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                
                
                if (adminData.adminData.containsKey(username) && adminData.adminData.get(username).equals(password)) {
                    System.out.println("\nLogin successful. Welcome, " + username + "!");
                    break;
                    }

                    else {
                    System.out.println("Invalid username or password, please try again. ( Attempts left: " + (i) +")");
                    if(i==0){
                        System.out.println("You have exceeded the maximum number of login attempts. Exiting program.");
                        System.exit(0);
                        }
                }
                }
                loggedIn = false;
            }

            // --- القائمة الرئيسية ---
            System.out.println("\nChoose an option:");
            System.out.println("1. Add manager");
            System.out.println("2. Add intern");
            System.out.println("3. Add engineer");
            System.out.println("4. Show all employees");
            System.out.println("5. Show employees spcecific details");
            System.out.println("6. Exit Program");
            
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
                        System.out.println("Do you want to add bonus for this manager? (yes/no): ");
                        String bonusResponse = scanner.nextLine().trim().toLowerCase();
                        
                        if (bonusResponse.equals("yes")) {
                            System.out.print("Enter Bonus Amount: ");
                            double bonus = scanner.nextDouble();
                            scanner.nextLine();
                            managers.add(new Manager(managers.size()+1, name, jobTitle, salary, bonus));
                        } else {    
                            managers.add(new Manager(managers.size()+1, name, jobTitle, salary, 0));
                        }

                        // استفسار المستخدم إذا كان يريد إضافة مدير آخر (تم إصلاح مكانه ليشمل الحالتين)
                        System.out.print("Do you want to add another manager? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        
                        if (response.equals("yes")) {
                            continue;
                        } else if (response.equals("no")){
                            System.out.println("Managers added successfully.");
                            break;
                        } else {
                            System.out.println("Invalid response. Exiting manager addition.");
                            break;
                        }
                    } // إغلاق حلقة while للمدير
                    break; // إغلاق case 1

                case 2:
                    while (true) {
                        System.out.println("Enter details for Intern #" + (interns.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        
                        interns.add(new Intern(interns.size()+1, name, jobTitle));

                        // استفسار المستخدم إذا كان يريد إضافة متدرب آخر
                        System.out.print("Do you want to add another intern? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equals("yes")) 
                            continue;
                        else if (response.equals("no")){
                            System.out.println("Interns added successfully.");
                            break;
                        } else {
                            System.out.println("Invalid response. Exiting intern addition.");
                            break;
                        }
                    }
                    System.out.println("Interns added successfully.");
                    break;
                    
                case 3: 
                    while(true){
                        System.out.println("Enter details for Engineer #" + (engineers.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); 
                        
                        engineers.add(new Engnieer(engineers.size()+1, name, jobTitle, salary, 8));
                        
                        // استفسار المستخدم إذا كان يريد إضافة مهندس آخر
                        System.out.print("Do you want to add another engineer? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equals("yes")) 
                            continue;
                        else if (response.equals("no")){
                            System.out.println("Engineers added successfully.");
                            break;
                        } else {
                            System.out.println("Invalid response. Exiting engineer addition.");
                            break;
                        }
                    } // إغلاق حلقة while للمهندس (كانت ناقصة)
                    break; // إغلاق case 3

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
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Managers details");
                    System.out.println("2. Interns details");
                    System.out.println("3. Engineers details");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); // تنظيف السطر بعد الرقم
                    switch (subChoice) {
                        case 1:
                            System.out.println("\nManagers Details:");
                            for (Manager m : managers) {
                                System.out.println("Details for the manager "+ m.getSubName() +"\n"+m.getFullDetails() +"\n");
                                
                            }
                            break;
                        case 2:
                            System.out.println("\nInterns Details:");
                            for (Intern in : interns) {
                                System.out.println(in.getFullDetails());
                            }
                            break;
                        case 3:
                            System.out.println("\nEngineers Details:");
                            for (Engnieer en : engineers) {
                                System.out.println(en.getFullDetails());
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;

                case 6:
                    System.out.println("Logging out. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}