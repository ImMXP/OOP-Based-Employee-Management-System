import java.util.Scanner;
import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
        boolean loggedIn = true;
        System.out.println("Welcome to Employee Management System");

        AdminstratorDATA adminData = new AdminstratorDATA(); 

        ArrayList<Employee> allEmployees = new ArrayList<>(); // ploymorphism array


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
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); 
                continue;
            } 
            
            switch (choice) {
                case 1:
                    while(true){
                        System.out.println("Enter details for Manager #" + (allEmployees.size() + 1)); //
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        String CheckName[] = name.split(" ");
                        if(CheckName.length != 3){
                            System.out.println("Please enter full name, e.g ( Ahmad adel saud )");
                            continue;
                        }
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        
                        double salary;
                        while(true){
                            try {
                            System.out.print("Enter Salary: ");
                            salary = scanner.nextDouble();
                            if(salary < 0){
                                System.out.println("ERROR : invalid input please write number greater than 0");
                                continue;
                            }else
                                scanner.nextLine();
                            }
                            catch (Exception InputMismatchException) {
                            System.out.println("Invalid input for salary. Please enter a valid number.");
                            scanner.nextLine();
                            continue;
                          }
                            break;
                        }
                        
                        System.out.println("Do you want to add bonus for this manager? (yes/no): ");
                        String bonusResponse = scanner.nextLine().trim().toLowerCase();
                        
                        if (bonusResponse.equalsIgnoreCase("yes") || bonusResponse.equalsIgnoreCase("y")) {
                            double bonus;
                            while(true){
                                try {
                                    System.out.print("Enter Bonus Amount: ");
                                    bonus = scanner.nextDouble();
                                    if(bonus < 0){
                                        System.out.println("ERROR : invalid input please write number greater than 0");
                                        continue;
                                    }else
                                        scanner.nextLine();
                                    allEmployees.add(new Manager(allEmployees.size()+1, name, jobTitle, salary, Math.round(bonus)));
                                }
                                catch (Exception InputMismatchException) {
                                    System.out.println("Invalid input for bonus, Please enter a valid number.");
                                    scanner.nextLine();
                                    continue;
                                }
                                break;
                            }
                        }else {
                            System.out.println("No bonus will be added for this manager.");
                            allEmployees.add(new Manager(allEmployees.size()+1, name, jobTitle, salary, 0));
                        }

                        // استفسار المستخدم إذا كان يريد إضافة مدير آخر (تم إصلاح مكانه ليشمل الحالتين)
                        System.out.print("Do you want to add another manager? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        
                        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
                            continue;
                        } else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")){
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
                        System.out.println("Enter details for Intern #" + (allEmployees.size() + 1));
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        String CheckName[] = name.split(" ");
                        if(CheckName.length != 3){
                            System.out.println("Please enter full name, e.g ( Ahmad adel saud )");
                            continue;
                        }
                        System.out.print("Enter Job Title: ");
                        String jobTitle = scanner.nextLine();
                        
                        allEmployees.add(new Intern(allEmployees.size()+1, name, jobTitle));

                        // استفسار المستخدم إذا كان يريد إضافة متدرب آخر
                        System.out.print("Do you want to add another intern? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y"))
                            continue;
                        else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")){
                            System.out.println("Interns added successfully.");
                            break;
                        } else {
                            System.out.println("Invalid response. Exiting intern addition.");
                            break;
                        }
                    }
                    break;
                    
                case 3: 
                    while(true){
                        System.out.println("Enter details for Engineer #" + (allEmployees.size() + 1));
                        System.out.print("Enter Name :");
                        String name = scanner.nextLine();
                        String CheckName[] = name.split(" ");
                        if(CheckName.length != 3){
                            System.out.println("Please enter full name, e.g ( Ahmad adel saud )");
                            continue;
                        }
                        System.out.print("Enter Job Title :");
                        String jobTitle = scanner.nextLine();
                        double hourlyRate;
                        while(true){
                            try{
                                System.out.print("Enter hourly rate (Default work hour is 8 Hours ) :");
                                hourlyRate = scanner.nextDouble();
                                if(hourlyRate < 0){
                                    System.out.println("ERROR : invalid input please write number greater than 0");
                                    continue;
                                }else
                                    scanner.nextLine();
                            } catch (Exception InputMismatchException) {
                                System.out.println("ERROR : Enter invalid number .");
                                scanner.nextLine();
                                continue;
                            }
                            break;
                        }
                        allEmployees.add(new Engnieer(allEmployees.size()+1, name, jobTitle, hourlyRate, 8));

                        // استفسار المستخدم إذا كان يريد إضافة مهندس آخر
                        System.out.print("Do you want to add another engineer? (yes/no): ");
                        String response = scanner.nextLine().trim().toLowerCase();
                        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y"))
                            continue;
                        else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")){
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
                    for(Employee a : allEmployees){
                        System.out.println(a.getDetails());
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
                            for (Employee m : allEmployees) {

                                if(m instanceof Manager i){
                                    System.out.println("Details for the manager "+ i.getSubName() +"\n"+i.getFullDetails() +"\n");
                                }
                            }


                            break;
                        case 2:
                            System.out.println("\nInterns Details:");
                            for (Employee m : allEmployees) {
                                if(m instanceof Intern i){
                                    System.out.println("Details for the manager "+ i.getSubName() +"\n"+i.getFullDetails() +"\n");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("\nEngnieer Details:");
                            for (Employee m : allEmployees) {
                                if(m instanceof Engnieer i){
                                    System.out.println("Details for the manager "+ i.getSubName() +"\n"+i.getFullDetails() +"\n");
                                }
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