public abstract class Employee{
    private String name; 
    private String id;
    private String jobTitle;
    // ---- ^^ fields ^^ ----

    public Employee(String id, String name,String jobTitle){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle ;
    }
    public abstract double calculateSalary();
    
    public String getDetails(){
        return "Employee name : " + this.name + "\nEmployee id :" + this.id + "\nJob title : " + this.jobTitle ;
    }
} 
