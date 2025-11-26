public class Engnieer extends Employee{

     private double hourlyRate;
     private int hoursWorked;


     public Engnieer(int id,String name,String jobTitle,double Rate,int hours){
            super(id, name, jobTitle);
            hourlyRate = Rate;
            hoursWorked = hours;

            
        
     }

     @Override
     public double calculateSalary(){
        return hourlyRate * hoursWorked ;
     }
     
     @Override
       public String getFullDetails(){
       return super.getDetails() + "\nJob Title : Engineer" +
       "\nHourly Rate : " + 
       this.hourlyRate + 
       "\nHours Worked : " + 
       this.hoursWorked + 
       "\nSalary : " + this.calculateSalary();
       }






}