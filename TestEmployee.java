public class TestEmployee{
    public static void main(String[] args) {
        Employee e1 = new Engnieer("E0001", "ahmad" ,"Engineer",199.99,8);
        Employee i1 = new Intern("I0001","Odai","Intern");
        System.out.println("---- \tEmployee details\t ----\n" + e1.getDetails() + "\nSalary = " +e1.calculateSalary()+"$" );
        System.out.println("---- \tEmployee details\t ----\n" + i1.getDetails() + "\nSalary = " +i1.calculateSalary()+"$" );
        
    }
}