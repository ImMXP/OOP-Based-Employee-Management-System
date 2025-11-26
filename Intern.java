public class Intern extends Employee{
    private double fixedStipend ;
    
    public Intern(int id, String name, String jobTitle){
        super(id,name,jobTitle) ;
        fixedStipend = 990.00 ;

    }

    @Override
    public double calculateSalary(){
        return fixedStipend ;
    }
    
    @Override
    public String getFullDetails(){
        return "ID :" + super.getId() + " | " + super.getName() + "\nJob Title : " + super.getJobTitle() + "\nSalary : " + this.calculateSalary() + "$";
    }
}