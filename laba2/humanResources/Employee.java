package humanResources;

public class Employee {
    private String firstName;
    private String secondName;
    private String jobTitle;
    private double salary;
    private final static String DEFAULT_STRING = "";
    private final static double DEFAULT_SALARY = 0;
    public Employee()
    {
        this("", "", DEFAULT_STRING, DEFAULT_SALARY);
    }
    public Employee(String firstName, String secondName)
    {
        this(firstName, secondName, DEFAULT_STRING, DEFAULT_SALARY);
    }
    public Employee(String firstName, String secondName, String jobTitle, double salary)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}