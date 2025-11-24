public class Engnieer extends Employee{

     private double hourlyRate;
     private int hoursWorked;


     public Engnieer(String id,String name,String jobTitle,double Rate,int hours){
            super(id, name, jobTitle);
            hourlyRate = Rate;
            hoursWorked = hours;

            
        
     }

     @Override
     public double calculateSalary(){
        return hourlyRate * hoursWorked ;
     }






}