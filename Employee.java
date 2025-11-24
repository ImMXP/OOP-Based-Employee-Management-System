public abstract class Employee{
    private String name; 
    private int id;
    private String jobTitle;
    // ---- ^^ fields ^^ ----

    public Employee(int id, String name,String jobTitle){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle ;
    }
    public abstract double calculateSalary();
    
    public String getDetails(){
        return "ID :" + this.id + " | Name : " + this.name;
    }
    public String getFullDetails(){
        return "Employee name : " + this.name + "\nEmployee id :" + this.id + "\nJob title : " + this.jobTitle ;
    }
} 
