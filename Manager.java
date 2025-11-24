public class Manager extends Employee{
     private double baseSalary;
     private double bonus;


     public Manager(int id,String name,String jobTitle,double baseSalary,double bouns){
            super(id, name,jobTitle);
            this.baseSalary = baseSalary;
            this.bonus = bouns ;
     }
     
     @Override
     public double calculateSalary(){
        return this.baseSalary + this.bonus ;
     }
}