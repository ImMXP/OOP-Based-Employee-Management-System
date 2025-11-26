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
    // ---- ^^ constructor ^^ ----

    public String getSubName()
    {String[] subName = this.name.split(" "); // Split the name by spaces
    return subName[0] +" "+ subName[1].charAt(0) +" " + subName[2];} // Return the formatted name

    public int getId(){return this.id ;}
    public String getName(){return this.name;} 
    public String getJobTitle(){return this.jobTitle;}
    public String getDetails(){return "ID :" + this.id + " | Name : " + getSubName();}
    // ---- ^^ getters & AKA concrete methods ^^ ----

    public abstract double calculateSalary();
    public abstract String getFullDetails();
    // ---- ^^ abstract methods ^^ ----
} 
